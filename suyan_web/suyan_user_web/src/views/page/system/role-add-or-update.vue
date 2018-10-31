<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="系统名称" prop="name">
        <el-input v-model="dataForm.name" placeholder="系统名称"></el-input>
      </el-form-item>
      <el-form-item label="系统编码" prop="sysCode">
        <el-input v-model="dataForm.sysCode" placeholder="系统编码"></el-input>
      </el-form-item>
      <el-form-item label="首页链接" prop="link">
        <el-input v-model="dataForm.link" placeholder="首页链接"></el-input>
      </el-form-item>
      <el-form-item label="应用ID" prop="serviceId">
        <el-input v-model="dataForm.serviceId" placeholder="应用ID"></el-input>
      </el-form-item>
      <el-form-item label="应用链接" prop="path">
        <el-input v-model="dataForm.path" placeholder="应用链接"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { treeDataTranslate } from '@/utils'
  export default {
    data () {
      return {
        visible: false,
        menuList: [],
        menuListTreeProps: {
          label: 'name',
          children: 'children'
        },
        dataForm: {
          id: null,
          name: '',
          sysCode: '',
          link: '',
          serviceId: '',
          path: '',
        },
        dataRule: {
          name: [
            { required: true, message: '系统名称不能为空', trigger: 'blur' }
          ],
          sysCode: [
            { required: true, message: '系统编码不能为空', trigger: 'blur' }
          ]
        },
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || null;
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields();
        })

        if (this.dataForm.id) {
          this.$http({
            url: this.$http.adornUrl(`system/getSystem/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.dataForm.name = data.dataMap.name;
              this.dataForm.sysCode = data.dataMap.sysCode;
              this.dataForm.link = data.dataMap.link;
              this.dataForm.serviceId = data.dataMap.serviceId;
              this.dataForm.path = data.dataMap.path;
              console.log(this.dataForm)
            }
          })
        }

      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/system/${!this.dataForm.id ? 'createSystem' : 'updateSystem'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'sysCode': this.dataForm.sysCode,
                'link': this.dataForm.link,
                'serviceId': this.dataForm.serviceId,
                'path': this.dataForm.path,
                'sysStatus': 0,
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
