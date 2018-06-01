<template>
    <div style="margin-left: 25px">
        <div style="float: right">
            <el-button type="primary" @click="add">添加</el-button>
            <el-button type="primary" @click="back">返回</el-button>
        </div>
        <el-table :data="tableData">
            <el-table-column
                    label="ID"
                    width="80">
                <template slot-scope="scope">
                    <span>{{ scope.row.jobId }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="名称"
                    width="120">
                <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                        <p>部门名: {{ scope.row.name }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.title }}</el-tag>
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
                    <el-button size="mini" @click="edit(scope.row.jobId)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="del(scope.row.jobId)">删除</el-button>
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
        name: "JobList",
        created: function () {
            this.companyId= this.$route.params.cid;
            this.departmentId= this.$route.params.did;
            this.getPager(1);
        },
        data: function () {
            return {
                companyId:0,
                departmentId:0,
                pagerData: {
                    totalPage: 0
                },
                tableData: []
            }
        },
        methods: {
            back:function(){
                this.$router.push("/home/departmentlist/" + this.companyId);
            },
            getPager: function(page) {
                var that = this;
                httphelper.authedpostform(urls.job_pager_url, {"page": page, "size": 10,"departmentId":that.departmentId},
                    function (data) {
                        that.tableData = data.data;
                        that.pagerData.totalPage = data.total / data.pageSize;
                        if (that.pagerData.totalPage < 1) {
                            that.pagerData.totalPage = 1;
                        }
                    })
            },
            add: function() {
                this.$router.push("/home/jobedit/"+this.companyId+"/"+this.departmentId);
            },
            edit: function(id) {
                this.$router.push("/home/jobedit/"+this.companyId+"/"+this.departmentId+"/"+id);
            },
            del: function(id) {
                var that = this;
                httphelper.authedpostform(urls.job_del_url, {"id": id},
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