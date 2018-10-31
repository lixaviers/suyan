<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="所属系统" prop="systemId">
        <el-select v-model="dataForm.systemId" placeholder="请选择" @change="change">
          <el-option
            v-for="system in systemList"
            :key="system.id"
            :label="system.name"
            :value="system.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-radio-group v-model="dataForm.type">
          <el-radio v-for="(type, index) in dataForm.typeList" :label="index" :key="index">{{ type }}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item :label="dataForm.typeList[dataForm.type] + '名称'" prop="name">
        <el-input v-model="dataForm.name" :placeholder="dataForm.typeList[dataForm.type] + '名称'"></el-input>
      </el-form-item>
      <el-form-item label="上级菜单" prop="parentName">
        <el-popover
          ref="menuListPopover"
          placement="bottom-start"
          trigger="click">
          <el-tree
            :data="menuList"
            :props="menuListTreeProps"
            node-key="id"
            ref="menuListTree"
            @current-change="menuListTreeCurrentChangeHandle"
            :default-expand-all="true"
            :highlight-current="true"
            :expand-on-click-node="false">
          </el-tree>
        </el-popover>
        <el-input v-model="dataForm.parentName" v-popover:menuListPopover :readonly="true" placeholder="点击选择上级菜单" class="menu-list__input"></el-input>
      </el-form-item>
      <el-form-item label="权限码" prop="resourceCode">
        <el-input v-model="dataForm.resourceCode" placeholder="多个用逗号分隔, 如: user:list,user:create"></el-input>
      </el-form-item>
      <el-form-item v-if="dataForm.type != 1" label="菜单路由" prop="url">
        <el-input v-model="dataForm.url" placeholder="菜单路由"></el-input>
      </el-form-item>
      <el-form-item label="排序号" prop="sortNumber">
        <el-input-number v-model="dataForm.sortNumber" controls-position="right" :min="1" label="排序号"></el-input-number>
      </el-form-item>
      <el-form-item v-if="dataForm.type == 0" label="菜单图标" prop="icon">
        <el-row>
          <el-col>
            <el-popover
              ref="iconListPopover"
              placement="bottom-start"
              trigger="click"
              popper-class="mod-menu__icon-popover">
              <div class="mod-menu__icon-list">
                <el-button
                  v-for="(item, index) in iconList"
                  :key="index"
                  @click="iconActiveHandle(item)"
                  :class="{ 'is-active': item === dataForm.icon }">
                  <icon-svg :name="item"></icon-svg>
                </el-button>
              </div>
            </el-popover>
            <el-input v-model="dataForm.icon" v-popover:iconListPopover :readonly="true" placeholder="菜单图标名称" class="icon-list__input"></el-input>
          </el-col>
        </el-row>
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
  import Icon from '@/icons'
  export default {
    data () {
      var validateUrl = (rule, value, callback) => {
        if (this.dataForm.type === 1 && !/\S/.test(value)) {
          callback(new Error('菜单URL不能为空'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        systemList: [],
        dataForm: {
          id: 0,
          systemId: null,
          type: 0,
          typeList: ['菜单', '按钮', '接口'],
          name: '',
          parentId: null,
          parentName: '',
          url: '',
          resourceCode: '',
          sortNumber: 0,
          icon: '',
          iconList: []
        },
        dataRule: {
          systemId: [
            { required: true, message: '所属系统不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '菜单名称不能为空', trigger: 'blur' }
          ],
          resourceCode: [
            { required: true, message: '权限码不能为空', trigger: 'change' }
          ],
          url: [
            { validator: validateUrl, trigger: 'blur' }
          ]
        },
        menuList: [],
        menuListTreeProps: {
          label: 'name',
          children: 'children'
        }
      }
    },
    created () {
      this.iconList = Icon.getNameList();
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0

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
        }).then(() => {
          this.visible = true
          this.$nextTick(() => {
            this.$refs['dataForm'].resetFields()
          })
        }).then(() => {
          if (!this.dataForm.id) {
            // 新增
            this.menuListTreeSetCurrentNode()
          } else {
            // 修改
            this.$http({
              url: this.$http.adornUrl(`resource/getResource/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              this.dataForm.id = data.dataMap.id;
              this.dataForm.systemId = data.dataMap.systemId;
              this.dataForm.type = data.dataMap.type;
              this.dataForm.name = data.dataMap.name;
              this.dataForm.parentId = data.dataMap.parentId;
              this.dataForm.url = data.dataMap.url;
              this.dataForm.resourceCode = data.dataMap.resourceCode;
              this.dataForm.sortNumber = data.dataMap.sortNumber;
              this.dataForm.icon = data.dataMap.icon;
              this.change();
              this.menuListTreeSetCurrentNode();
            })
          }
        })
      },
      change() {
        this.$http({
          url: this.$http.adornUrl('resource/getTreeResource/' + this.dataForm.systemId),
          method: 'get',
        }).then(({data}) => {
            if(data.dataMap && data.dataMap.length > 0) {
              this.menuList = treeDataTranslate(data.dataMap, 'id')
            } else {
              this.menuList = []
            }
        });
      },
      // 菜单树选中
      menuListTreeCurrentChangeHandle (data, node) {
        this.dataForm.parentId = data.id;
        this.dataForm.parentName = data.name;
      },
      // 菜单树设置当前选中节点
      menuListTreeSetCurrentNode () {
        this.$refs.menuListTree.setCurrentKey(this.dataForm.parentId)
        this.dataForm.parentName = (this.$refs.menuListTree.getCurrentNode() || {})['name']
      },
      // 图标选中
      iconActiveHandle (iconName) {
        this.dataForm.icon = iconName
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`resource/${!this.dataForm.id ? 'createResource' : 'updateResource'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'systemId': this.dataForm.systemId,
                'type': this.dataForm.type,
                'name': this.dataForm.name,
                'parentId': this.dataForm.parentId,
                'url': this.dataForm.url,
                'resourceCode': this.dataForm.resourceCode,
                'sortNumber': this.dataForm.sortNumber,
                'icon': this.dataForm.icon
              })
            }).then(({data}) => {
              if (data && data.code === 200) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false;
                    this.$emit('refreshDataList');
                  }
                })
              } else {
                this.$message.error(data.message);
              }
            })
          }
        })
      }
    }
  }
</script>

<style lang="scss">
  .mod-menu {
    .menu-list__input,
    .icon-list__input {
       > .el-input__inner {
        cursor: pointer;
      }
    }
    &__icon-popover {
      max-width: 370px;
    }
    &__icon-list {
      max-height: 180px;
      padding: 0;
      margin: -8px 0 0 -8px;
      > .el-button {
        padding: 8px;
        margin: 8px 0 0 8px;
        > span {
          display: inline-block;
          vertical-align: middle;
          width: 18px;
          height: 18px;
          font-size: 18px;
        }
      }
    }
    .icon-list__tips {
      font-size: 18px;
      text-align: center;
      color: #e6a23c;
      cursor: pointer;
    }
  }
</style>
