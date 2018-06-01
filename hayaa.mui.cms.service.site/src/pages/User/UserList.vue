<template>
    <div style="margin-left: 25px">
        <el-row>
            <el-col :span="24">
                <el-input style="width: 400px;"
                        placeholder="输入关键字进行过滤"
                        v-model="filterText">
                </el-input> <el-button size="small" type="primary" @click="search">搜索</el-button>
            </el-col>
        </el-row>
        <el-row>
            <div style="float: right">
                <el-button  size="small" type="primary" @click="add">添加</el-button>
            </div>
            <el-table :data="tableData">
                <el-table-column
                        label="用户ID"
                        width="80">
                    <template slot-scope="scope">
                        <el-popover trigger="hover" placement="top">
                            <p>人员ID: {{ scope.row.personId }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-tag size="medium">{{ scope.row.userId }}</el-tag>
                            </div>
                        </el-popover>
                    </template>
                </el-table-column>
                <el-table-column
                        label="姓名"
                        width="120">
                    <template slot-scope="scope">
                        <el-popover trigger="hover" placement="top">
                            <div><img :src="scope.row.photo" style="width: 120px;height:100px;"/></div>
                            <div slot="reference" class="name-wrapper">
                                <el-tag size="medium">{{ scope.row.name }}</el-tag>
                            </div>
                        </el-popover>
                    </template>
                </el-table-column>
                <el-table-column
                        label="昵称"
                        width="120">
                    <template slot-scope="scope">
                        <span>{{ scope.row.nickName }}</span>
                    </template>
                </el-table-column>
                <el-table-column
                        label="岗位"
                        width="120">
                    <template slot-scope="scope">
                        <span>{{ scope.row.jobName  }}</span>
                    </template>
                </el-table-column>
                <el-table-column
                        label="部门"
                        width="120">
                    <template slot-scope="scope">
                        <el-popover trigger="hover" placement="top">
                             <p>所属公司: {{ scope.row.company }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-tag size="medium">{{ scope.row.department }}</el-tag>
                            </div>
                        </el-popover>
                    </template>
                </el-table-column>
                <el-table-column
                        label="创建时间"
                        width="180">
                    <template slot-scope="scope">
                        <span>{{ scope.row.createTime }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="edit(scope.row.userId)">编辑</el-button>
                        <el-button size="mini" @click="setJob(scope.row.userId)">设置岗位</el-button>
                        <!--<el-button size="mini" type="danger" @click="del(scope.row.userId)">删除</el-button>-->
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
        </el-row>
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
                filterText:"",
                pagerData: {
                    totalPage: 0
                },
                tableData: []
            }
        },
        methods: {
            getPager: function (page) {
                var that = this;
                httphelper.authedpostform(urls.user_pager_url, {"page": page, "size": 10, "nickName": that.filterText},
                    function (data) {
                        that.tableData = data.data;
                        that.pagerData.totalPage = data.total / data.pageSize;
                        if (that.pagerData.totalPage < 1) {
                            that.pagerData.totalPage = 1;
                        }
                    })
            },
            add: function () {
                this.$router.push("/home/useradd");
            },
            edit:function(id){
                this.$router.push("/home/useredit/"+id);
            },
            setJob:function(id){
                this.$router.push("/home/setjob/"+id);
            },
            search: function (id) {
                this.getPager(1);
            },
            del: function (id) {
                var that = this;
                httphelper.authedpostform(urls.appDeleteUrl, {"appId": id},
                    function (data) {
                        if (data)
                            that.$notify.success("操作成功");
                    });
            }
        }
    }
</script>

<style scoped>

</style>