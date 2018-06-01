<template>
    <div style="margin-left: 25px">
        <div style="float: right">
            <el-button type="primary" @click="add">添加</el-button>
        </div>
        <el-table :data="tableData">
            <el-table-column
                    label="ID"
                    width="80">
                <template slot-scope="scope">
                    <span>{{ scope.row.companyId }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="名称"
                    width="120">
                <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                        <p>全名: {{ scope.row.companyFullName }}</p>
                        <p>企业编码: {{ scope.row.companyCode }}</p>
                        <p>注册日期: {{ scope.row.birdthday }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.companyName }}</el-tag>
                        </div>
                    </el-popover>
                </template>
            </el-table-column>
            <el-table-column
                    label="创建时间"
                    width="160">
                <template slot-scope="scope">
                    <span>{{ scope.row.createTime }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="更新时间"
                    width="160">
                <template slot-scope="scope">
                    <span>{{ scope.row.updateTime }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" @click="edit(scope.row.companyId)">编辑</el-button>
                    <el-button size="mini" @click="scan(scope.row.companyId)">总览</el-button>
                    <el-button size="mini" @click="editDepartment(scope.row.companyId)">部门管理</el-button>
                    <el-button size="mini" type="danger" @click="del(scope.row.companyId)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div style="float: right" v-show="pagerData.totalPage>0">
            <el-pagination
                    @current-change="getPager"
                    layout="prev, pager, next"
                    :total="pagerData.totalPage">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    import httphelper from '../../util/httphelper'
    import urls from '../../urlstatic'

    export default {
        name: "CompanyList",
        created: function () {
            this.getPager(1);
        },
        data: function () {
            return {
                pagerData: {
                    totalPage: 0
                },
                tableData: []
            }
        },
        methods: {
            getPager: function(page) {
                var that = this;
                httphelper.authedpostform(urls.company_pager_url, {"page": page, "size": 10},
                    function (data) {
                        that.tableData = data.data;
                        that.pagerData.totalPage = data.total / data.pageSize;
                        if (that.pagerData.totalPage < 1) {
                            that.pagerData.totalPage = 1;
                        }
                    })
            },
            add: function() {
                this.$router.push("/home/companyedit");
            },
            edit: function(id) {
                this.$router.push("/home/companyedit/" + id);
            },
            scan: function(id) {
                this.$router.push("/home/companyinfo/" + id);
            },
            editDepartment: function(id) {
                this.$router.push("/home/departmentlist/" + id);
            },
            del: function(id) {
                var that = this;
                httphelper.authedpostform(urls.company_del_url, {"id": id},
                    function (data) {
                        if(data)
                        that.$notify.success("操作成功");
                        that.getPager(1);
                    });
            }
        }
    }
</script>

<style scoped>

</style>