<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()"
             label-width="80px">
      <el-form-item label="角色名称" prop="roleName">
        <el-input v-model="dataForm.roleName" placeholder="角色名称"></el-input>
      </el-form-item>
      <el-form-item label="角色编码" prop="roleCode">
        <el-input v-model="dataForm.roleCode" placeholder="角色名称"></el-input>
      </el-form-item>
      <el-form-item label="所属系统" prop="systemId">
        <el-select v-model="dataForm.systemId" placeholder="请选择">
          <el-option
            v-for="system in systemList"
            :key="system.id"
            :label="system.name"
            :value="system.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="描述" prop="description">
        <el-input v-model="dataForm.description" placeholder="备注"></el-input>
      </el-form-item>
      <el-form-item size="mini" label="授权">
        <el-tree
          check-strictly
          :data="menuList"
          :props="menuListTreeProps"
          node-key="id"
          ref="menuListTree"
          :default-expand-all="true"
          show-checkbox>
        </el-tree>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import {treeDataTranslate} from '@/utils'
  export default {
    data () {
      return {
        visible: false,
        menuList: [],
        systemList: [],
        menuListTreeProps: {
          label: 'name',
          children: 'children'
        },
        dataForm: {
          id: 0,
          roleName: '',
          roleCode: '',
          systemId: null,
          description: ''
        },
        dataRule: {
          roleName: [
            {required: true, message: '角色名称不能为空', trigger: 'blur'}
          ],
          roleCode: [
            {required: true, message: '角色编码不能为空', trigger: 'blur'}
          ]
        },
        tempKey: -666666 // 临时key, 用于解决tree半选中状态项不能传给后台接口问题. # 待优化
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || null;
        this.$http({
          url: this.$http.adornUrl('resource/getTreeResource'),
          method: 'get',
          params: this.$http.adornParams()
        }).then(({data}) => {
          this.menuList = treeDataTranslate(data.dataMap, 'id')
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('system/querySystem'),
            method: 'post',
            data: this.$http.adornData({
              'pageNo': this.pageIndex,
              'pageSize': this.pageSize,
              'isDeleted': false,
              'orderBy': 'id',
              'order': 'asc',
            })
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.systemList = data.dataMap.records;
            } else {
              this.systemList = []
            }
          })
        }).then(() => {
          this.visible = true
          this.$nextTick(() => {
            this.$refs['dataForm'].resetFields()
            this.$refs.menuListTree.setCheckedKeys([])
          })
        }).then(() => {
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`role/getRole/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.dataForm.roleName = data.dataMap.roleName;
                this.dataForm.roleCode = data.dataMap.roleCode;
                this.dataForm.description = data.dataMap.description;
                this.dataForm.systemId = data.dataMap.systemId;
                var idx = data.dataMap.resourceIdList.indexOf(this.tempKey)
                if (idx !== -1) {
                  data.dataMap.resourceIdList.splice(idx, data.dataMap.resourceIdList.length - idx)
                }
                this.$refs.menuListTree.setCheckedKeys(data.dataMap.resourceIdList);
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/role/${!this.dataForm.id ? 'createRole' : 'updateRole'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'roleName': this.dataForm.roleName,
                'roleCode': this.dataForm.roleCode,
                'description': this.dataForm.description,
                'systemId': this.dataForm.systemId,
                'roleStatus': 0,
                'resourceIdList': [].concat(this.$refs.menuListTree.getCheckedKeys(), [this.tempKey], this.$refs.menuListTree.getHalfCheckedKeys())
              })
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
