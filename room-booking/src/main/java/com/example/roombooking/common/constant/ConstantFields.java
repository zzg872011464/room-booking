package com.example.roombooking.common.constant;

public class ConstantFields {

    // 系统操作用户名
    public static final String SYSTEM_USER_ID = "1111";

    // 空字符串
    public static final String BLANK_STRING = "";
    // 英文逗号
    public static final String EN_COMMA = ",";
    // 英文冒号
    public static final String EN_COLON = ":";
    // 英文点
    public static final String EN_POINT = ".";
    // 空格
    public static final String EN_BLANK = " ";
    // 下滑线
    public static final String UNDER_LINE_STRING = "_";
    // 左斜线
    public static final String LEFT_SLASH_STRING = "\\";
    // 右斜线
    public static final String RIGHT_SLASH_STRING = "/";
    // 中横线
    public static final String MIDDLE_LINE_STRING = "-";

    // 拼音首字母拼接多音字最大长度限制
    public static final int EN_NAME_DUO_YIN_ZI_MAX_LENGTH_LIMIT = 2;

    // 批量操作返回信息
    public static final String OPERATION_BATCH_ERROR_NO_DATA = "批量操作错误，原因为无数据";
    public static final String OPERATION_BATCH_ERROR_NO_USER_ID = "批量操作错误，原因为无操作人ID";
    public static final String OPERATION_BATCH_OK = "批量操作成功";
    public static final String OPERATION_BATCH_ERROR = "批量操作失败";

    // 批量操作返回数据中的操作码
    public static final int BATCH_CREATE_DATA_OK = 1;
    public static final int BATCH_CREATE_DATA_NOT_OK = 2;
    public static final int BATCH_UPDATE_DATA_OK = 3;
    public static final int BATCH_UPDATE_DATA_NOT_OK = 4;
    public static final int BATCH_DELETE_DATA_OK = 5;
    public static final int BATCH_DELETE_DATA_NOT_OK = 6;
    public static final int BATCH_DELETE_DB_DATA_OK = 7;
    public static final int BATCH_DELETE_DB_DATA_NOT_OK = 8;

    // 批量操作返回数据中的提示信息
    public static final String BATCH_CREATE_DATA_OK_MSG = "正确添加";
    public static final String BATCH_UPDATE_DATA_OK_MSG = "正确修改";
    public static final String BATCH_DELETE_DATA_OK_MSG = "正确逻辑删除";
    public static final String BATCH_DELETE_DATA_NOT_OK_MSG = "未正确逻辑删除";
    public static final String BATCH_DELETE_DB_DATA_OK_MSG = "正确物理删除";
    public static final String BATCH_DELETE_DB_DATA_NOT_OK_MSG = "未正确物理删除";

    // 请求头客户端type的key
    public static final String CLIENT_TYPE_KEY = "clientType";
    // 请求头token的key
    public static final String TOKEN_KEY = "token";
    // 请求头userId的key
    public static final String USER_ID_KEY = "userId";
    // 请求头time的key
    public static final String TIME_KEY = "time";

    // 添加操作的错误消息提示
    public static final String CREATE_ERROR_MSG = "添加数据不合法";
    public static final String DELETE_ERROR_MSG = "删除数据不合法";
    public static final String UPDATE_ERROR_MSG = "更新数据不合法";
    public static final String LIST_ERROR_MSG = "查询数据不合法";

    // 总父菜单ID
    public static final String TOP_PARENT_MENU_ID = "0";
    // 总父部门ID
    public static final String TOP_PARENT_DEPARTMENT_ID = "0";

    // 定义各个编号的前面补充
    public static final char PAD_NUMBER_CHAR = '0';

    // token超时时间，单位秒
    public static final long TOKEN_TIMEOUT_SECOND = 1800;

    // 删除标识符 0:未删除 1:已删除
    public static final int DELETE_FLAG_0 = 0;
    public static final int DELETE_FLAG_1 = 1;

    // 启停标识符 0:启用 1:停用
    public static final int LOCK_FLAG_0 = 0;
    public static final int LOCK_FLAG_1 = 1;

    // 隐藏标识符 0:不隐藏 1:隐藏
    public static final int HIDDEN_FLAG_0 = 0;
    public static final int HIDDEN_FLAG_1 = 1;

    // 外链标识符 0:不是外链 1:是外链
    public static final int FRAME_FLAG_0 = 0;
    public static final int FRAME_FLAG_1 = 1;

    // 是否缓存标识符 0:不缓存 1:缓存
    public static final int CACHE_FLAG_0 = 0;
    public static final int CACHE_FLAG_1 = 1;

    // minio总的bucketName
    public static final String BUCKET_NAME = "pashanhu-position";
    // minio导入文件的bucketName
    public static final String DAORU_BUCKET_NAME = "pashanhu-position-daoru";

    //关联文件Id类型
    public static final String CORRELATION_ROOM_NAME = "room";
    public static final String CORRELATION_ACTIVITY_NAME = "activity";
    public static final String CORRELATION_USER_NAME = "user";

    // 导入操作返回数据中的提示信息
    public static final String DAORU_OK_MSG = "导入数据成功";
    public static final String INSERT_DAORU_FILE_LOG_ERROR_MSG = "添加导入文件日志错误";
    public static final String DAORU_NOT_FILE_MSG = "导入失败，原因为无数据文件";
    public static final String DAORU_FILE_TYPE_ERROR = "导入失败，原因为文件类型错误";
    public static final String DAORU_NOT_USER_ID_MSG = "导入失败，原因为无操作人员";
    public static final String DAORU_UPLOAD_ERROR_MSG = "导入数据文件上传失败";
    public static final String ERROR_UPLOAD_ERROR_MSG = "错误数据文件上传失败";

    // 错误提示信息表头
    public static final String ERROR_MSG_HEAD = "错误提示信息";

    // 勿扰标识 0：不勿扰 1：勿扰
    public static final int WURAO_FLAG_0 = 0;
    public static final int WURAO_FLAG_1 = 1;

    // 房间占用状态 1:空闲 2:占用
    public static final int OCCUPANCY_STATE_FREE = 1;
    public static final int OCCUPANCY_STATE_OCCUPANCY = 2;

    /* Mybatis-Plus相关 */
    public static final int INSERT_ONE_SUCCESS = 1;
    public static final int UPDATE_ONE_SUCCESS = 1;
    private ConstantFields() {}
}
