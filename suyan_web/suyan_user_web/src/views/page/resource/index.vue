<template>
  <div class="mod-menu">
    <el-form :inline="true" :model="dataForm">
      <el-form-item>
        <el-button v-if="isAuth('upm:resource:add:button')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      style="width: 100%;">
      <table-tree-column
        prop="name"
        header-align="center"
        treeKey="id"
        label="名称">
      </table-tree-column>
      <el-table-column
        prop="resourceCode"
        header-align="center"
        align="center"
        :show-overflow-tooltip="true"
        label="权限码">
      </el-table-column>
      <el-table-column
        prop="url"
        header-align="center"
        align="center"
        :show-overflow-tooltip="true"
        label="菜单URL">
      </el-table-column>
      <el-table-column
        header-align="center"
        align="center"
        width="150"
        label="图标">
        <template slot-scope="scope">
          <icon-svg :name="scope.row.icon || ''"></icon-svg>
        </template>
      </el-table-column>
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        width="150"
        label="类型">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.type === 0" size="small">菜单</el-tag>
          <el-tag v-else-if="scope.row.type === 1" size="small" type="success">按钮</el-tag>
          <el-tag v-else-if="scope.row.type === 2" size="small" type="warning">接口</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="sortNumber"
        header-align="center"
        align="center"
        width="100"
        label="排序号">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button v-if="isAuth('upm:resource:edit:button')" type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button v-if="isAuth('upm:resource:delete:button')" type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import TableTreeColumn from '@/components/table-tree-column';
  import AddOrUpdate from './menu-add-or-update'
  import {treeDataTranslate} from '@/utils';
  export default {
    data () {
      return {
        dataForm: {},
        dataList: [],
        dataListLoading: false,
        addOrUpdateVisible: false
      }
    },
    components: {
      TableTreeColumn,
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true;
        this.$http({
          url: this.$http.adornUrl('resource/queryResource'),
          method: 'post',
          data: this.$http.adornData({
            'pageSize': 10000,
            'isDeleted': false,
            'orderBy': 'parent_id asc, sort_number asc, id asc',
          })
        }).then(({data}) => {
          this.dataList = treeDataTranslate(data.dataMap.records);
          this.dataListLoading = false;
        })
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        console.log(this.addOrUpdateVisible)
        this.addOrUpdateVisible = true;
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id);
        })
      },
      // 删除
      deleteHandle (id) {
        this.$confirm(`确定进行[删除]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl(`resource/deleteResource/${id}`),
            method: 'post',
            data: this.$http.adornData()
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        }).catch(() => {})
      }
    }
  }
</script>
