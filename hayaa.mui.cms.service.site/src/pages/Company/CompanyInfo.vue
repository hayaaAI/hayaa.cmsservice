<template>
    <div>
        <el-row>
            <el-col :span="24">
                <el-input
                        placeholder="输入关键字进行过滤"
                        v-model="filterText">
                </el-input>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="6">
                <div style="margin-top: 10px;">
                    <el-tree :data="data" :props="defaultProps" default-expand-all @node-click="handleNodeClick"
                             :filter-node-method="filterNode" ref="dtree"></el-tree>
                </div>
            </el-col>
            <el-col :span="18">
                <div style="margin-top: 5px; float: right">
                    <el-button size="small" type="primary" @click="add" v-show="departmentId>0">添加</el-button>
                </div>
                <el-table
                        :data="tableData"
                        style="width: 100%">
                    <el-table-column
                            label="ID"
                            width="80">
                        <template slot-scope="scope">
                            <span>{{ scope.row.personId }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="名称"
                            width="120">
                        <template slot-scope="scope">
                            <el-popover trigger="hover" placement="top">
                                <p v-if="!scope.row.sex">性别: 男</p>
                                <p v-else>性别: 女</p>
                                <p>生日: {{ scope.row.birthday }}</p>
                                <p>注册日期: {{ scope.row.id }}</p>
                                <div slot="reference" class="name-wrapper">
                                    <el-tag size="medium">{{ scope.row.name }}</el-tag>
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
                            <el-button size="mini" @click="edit(scope.row.personId)">基础信息编辑</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
    </div>

</template>

<script>
    import httphelper from '../../util/httphelper'
    import urls from '../../urlstatic'

    export default {
        name: "CompanyInfo",
        watch: {
            filterText: function (val) {
                this.$refs.dtree.filter(val);
            }
        },
        data: function () {
            return {
                companyId: 0,
                departmentId: 0,
                filterText: '',
                tableData: [],
                data: [],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        created: function () {
            this.companyId = this.$route.params.id;
            this.getlist();
        },
        methods: {
            add: function () {
                this.$router.push("/home/personedit/" + this.companyId + "/" + this.departmentId);
            },
            edit: function (id) {
                this.$router.push("/home/personedit/" + this.companyId + "/" + this.departmentId + "/" + id);
            },
            getlist: function () {
                var that = this;
                httphelper.authedpostform(urls.department_list_url, {"companyId": that.companyId},
                    function (data) {
                        for (var i = 0; i < data.length; i++) {
                            if (!data[i].parentId) {
                                that.data.push({
                                    id: data[i].departmentId,
                                    label: data[i].title,
                                    children: []
                                });
                                data.splice(i, 1);
                                i = i - 1;
                            }
                        }
                        that.nodeMake(that.data, data);
                    })
            },
            nodeMake: function (treedata, data) {
                var that = this;
                for (var j = 0; j < treedata.length; j++) {
                    for (var i = 0; i < data.length; i++) {
                        if (treedata[j].id == data[i].parentId) {
                            treedata[j].children.push({
                                id: data[i].departmentId,
                                label: data[i].title,
                                children: []
                            });
                            data.splice(i, 1);
                        }
                    }
                    if (data.length > 0)
                        that.nodeMake(treedata[j].children, data);
                }
            },
            handleNodeClick: function (data) {
                this.departmentId = data.id;
                var that = this;
                httphelper.authedpostform(urls.person_list_url, {"departmentId": that.departmentId},
                    function (data) {
                        that.tableData = data;
                    }, function (data) {
                        that.tableData = [];
                    });
            },
            filterNode: function (value, data) {
                if (!value) return true;
                return data.label.indexOf(value) !== -1;
            }
        }
    }
</script>

<style scoped>

</style>