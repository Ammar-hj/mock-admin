
# mock

## POST 获取mock核心服务地址

POST /mock_web/core/addr

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|object|false|none||none|

## POST 添加节点

POST /mock/space/add

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|label|query|string| 是 |节点名称|
|parentId|query|integer| 是 |父节点值，根节点为0|
|accessAuthority|query|string| 否 |节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 |层级|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "创建成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 修改节点

POST /mock/space/update

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|label|query|string| 否 |节点名称|
|parentId|query|integer| 否 |父节点值，根节点为0|
|accessAuthority|query|string| 否 |节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 |层级|
|id|query|integer| 是 |id|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "修改成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 删除节点

POST /mock/space/delete

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |id|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "删除成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 获取所有节点

POST /mock/space/list

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": [
    {
      "id": 91,
      "label": "ammar",
      "parentId": 0,
      "accessAuthority": "PUBLIC",
      "level": 1,
      "ctime": "2023-03-09T01:45:31.000+0000",
      "mtime": "2023-03-09T01:46:10.000+0000",
      "children": [
        {
          "id": 92,
          "label": "test",
          "parentId": 91,
          "accessAuthority": "PUBLIC",
          "level": 2,
          "ctime": "2023-03-09T01:48:40.000+0000",
          "mtime": "2023-03-09T01:48:40.000+0000",
          "children": [],
          "path": [
            91,
            92
          ],
          "allowCreateInterface": true,
          "allowCreateSpace": false,
          "variable": true
        }
      ],
      "path": [
        91
      ],
      "allowCreateInterface": false,
      "allowCreateSpace": true,
      "variable": true
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|false|none|节点ID|none|
|»» label|string|false|none|节点名称|none|
|»» parentId|integer|false|none|父节点ID|none|
|»» accessAuthority|string|false|none|权限|none|
|»» level|integer|false|none|层级|none|
|»» ctime|string|false|none||none|
|»» mtime|string|false|none||none|
|»» children|[object]|false|none|子节点|none|
|»»» id|integer|false|none||none|
|»»» label|string|false|none||none|
|»»» parentId|integer|false|none||none|
|»»» accessAuthority|string|false|none||none|
|»»» level|integer|false|none||none|
|»»» ctime|string|false|none||none|
|»»» mtime|string|false|none||none|
|»»» children|[string]|false|none||none|
|»»» path|[integer]|false|none||none|
|»»» allowCreateInterface|boolean|false|none||none|
|»»» allowCreateSpace|boolean|false|none||none|
|»»» variable|boolean|false|none||none|
|»» path|[integer]|false|none|路径|none|
|»» allowCreateInterface|boolean|false|none||none|
|»» allowCreateSpace|boolean|false|none||none|
|»» variable|boolean|false|none||none|

## POST 添加接口

POST /mock/http/add

> Body 请求参数

```json
{
  "requestUri": "string",
  "requestMethod": "string",
  "name": "string",
  "needAsyncCallback": true,
  "configMode": "string",
  "responseHeaderList": [
    {
      "name": "string",
      "value": "string"
    }
  ],
  "responseBody": "string",
  "callbackRequestUrl": "string",
  "callbackRequestMethod": "string",
  "callbackRequestHeaderList": [
    "string"
  ],
  "description": "string",
  "callbackRequestBody": "string",
  "branchJumpScript": "string",
  "syncScript": "string",
  "asyncScript": "string",
  "syncDelay": "string",
  "asyncDelay": 0,
  "start": true,
  "spaceId": 0,
  "branchScriptList": [
    "string"
  ]
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|label|query|string| 是 ||节点名称|
|parentId|query|integer| 是 ||父节点值，根节点为0|
|accessAuthority|query|string| 否 ||节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 ||层级|
|body|body|object| 否 ||none|
|» requestUri|body|string| 是 | 请求uri|none|
|» requestMethod|body|string| 是 | 请求方式|none|
|» name|body|string| 是 | 接口名称|none|
|» needAsyncCallback|body|boolean| 是 | 是否开启异步|none|
|» configMode|body|string| 是 | 模版类型|静态文本、groovy|
|» responseHeaderList|body|[object]| 是 | 响应头列表信息|none|
|»» name|body|string| 否 ||none|
|»» value|body|string| 否 ||none|
|» responseBody|body|string| 是 | 响应内容|none|
|» callbackRequestUrl|body|string| 是 | 回调uri|none|
|» callbackRequestMethod|body|string| 是 | 回调请求方式|none|
|» callbackRequestHeaderList|body|[string]| 是 | 回调请求头信息|none|
|» description|body|string| 是 | 描述|none|
|» callbackRequestBody|body|string| 是 | 回调请求内容|none|
|» branchJumpScript|body|string| 是 | 分支判断脚本|none|
|» syncScript|body|string| 是 | 同步grooy脚本|none|
|» asyncScript|body|string| 是 | 异步grooy脚本|none|
|» syncDelay|body|string| 是 | 同步延时|none|
|» asyncDelay|body|integer| 是 | 异步延时|none|
|» start|body|boolean| 是 | 是否开启|none|
|» spaceId|body|integer| 是 | 父节点ID|none|
|» branchScriptList|body|[string]| 是 | 分支list|none|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "创建成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 修改接口

POST /mock/http/update

> Body 请求参数

```json
{
  "requestUri": "string",
  "requestMethod": "string",
  "name": "string",
  "needAsyncCallback": true,
  "configMode": "string",
  "responseHeaderList": [
    {
      "name": "string",
      "value": "string"
    }
  ],
  "responseBody": "string",
  "callbackRequestUrl": "string",
  "callbackRequestMethod": "string",
  "callbackRequestHeaderList": [
    "string"
  ],
  "description": "string",
  "callbackRequestBody": "string",
  "branchJumpScript": "string",
  "syncScript": "string",
  "asyncScript": "string",
  "syncDelay": "string",
  "asyncDelay": 0,
  "start": true,
  "spaceId": 0,
  "branchScriptList": [
    "string"
  ]
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|label|query|string| 是 ||节点名称|
|parentId|query|integer| 是 ||父节点值，根节点为0|
|accessAuthority|query|string| 否 ||节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 ||层级|
|body|body|object| 否 ||none|
|» requestUri|body|string| 是 | 请求uri|none|
|» requestMethod|body|string| 是 | 请求方式|none|
|» name|body|string| 是 | 接口名称|none|
|» needAsyncCallback|body|boolean| 是 | 是否开启异步|none|
|» configMode|body|string| 是 | 模版类型|静态文本、groovy|
|» responseHeaderList|body|[object]| 是 | 响应头列表信息|none|
|»» name|body|string| 否 ||none|
|»» value|body|string| 否 ||none|
|» responseBody|body|string| 是 | 响应内容|none|
|» callbackRequestUrl|body|string| 是 | 回调uri|none|
|» callbackRequestMethod|body|string| 是 | 回调请求方式|none|
|» callbackRequestHeaderList|body|[string]| 是 | 回调请求头信息|none|
|» description|body|string| 是 | 描述|none|
|» callbackRequestBody|body|string| 是 | 回调请求内容|none|
|» branchJumpScript|body|string| 是 | 分支判断脚本|none|
|» syncScript|body|string| 是 | 同步grooy脚本|none|
|» asyncScript|body|string| 是 | 异步grooy脚本|none|
|» syncDelay|body|string| 是 | 同步延时|none|
|» asyncDelay|body|integer| 是 | 异步延时|none|
|» start|body|boolean| 是 | 是否开启|none|
|» spaceId|body|integer| 是 | 父节点ID|none|
|» branchScriptList|body|[string]| 是 | 分支list|none|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "修改成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 删除接口

POST /mock/http/delete

> Body 请求参数

```json
{
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|label|query|string| 是 ||节点名称|
|parentId|query|integer| 是 ||父节点值，根节点为0|
|accessAuthority|query|string| 否 ||节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 ||层级|
|body|body|object| 否 ||none|
|» id|body|integer| 是 ||none|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "修改成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 根据节点查询接口

POST /mock/http/queryBySpaceId

> Body 请求参数

```json
{
  "page": 0,
  "itemsPerPage": 0,
  "criteria": {
    "spaceId": 0
  }
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|label|query|string| 是 ||节点名称|
|parentId|query|integer| 是 ||父节点值，根节点为0|
|accessAuthority|query|string| 否 ||节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 ||层级|
|body|body|object| 否 ||none|
|» page|body|integer| 是 | 页码|none|
|» itemsPerPage|body|integer| 是 | 每页数量|none|
|» criteria|body|object| 是 ||none|
|»» spaceId|body|integer| 是 | 父节点ID|none|

> 返回示例

> 成功

```json
{
  "code": "0",
  "message": "成功",
  "data": "修改成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|string|true|none||none|

## POST 查询所有接口

POST /mock/http/queryAll

> Body 请求参数

```json
{
  "page": 0,
  "itemsPerPage": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|label|query|string| 是 ||节点名称|
|parentId|query|integer| 是 ||父节点值，根节点为0|
|accessAuthority|query|string| 否 ||节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 ||层级|
|body|body|object| 否 ||none|
|» page|body|integer| 是 | 页码|none|
|» itemsPerPage|body|integer| 是 | 每页数量|none|

> 返回示例

> 成功

```json
{
  "resultCode": "0",
  "resultMsg": "成功",
  "data": {
    "page": 1,
    "itemsPerPage": 13,
    "total": 4,
    "list": [
      {
        "requestUri": "/test1111",
        "requestMethod": "POST",
        "id": 103,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "TEXT",
        "responseBody": "{\"resp\":123}",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "",
        "syncScript": "",
        "asyncScript": "",
        "syncDelay": 1000,
        "asyncDelay": 0,
        "start": true,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "test111",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-15T06:14:25.000+0000",
        "gmtModified": "2023-03-15T06:14:25.000+0000",
        "responseHeaderList": [
          {
            "name": "test",
            "value": "emmmm"
          }
        ],
        "callbackRequestHeaderList": [],
        "branchScriptList": [],
        "path": [
          91,
          92
        ],
        "variable": true
      },
      {
        "requestUri": "/test4",
        "requestMethod": "GET",
        "id": 102,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "GROOVY_TEMPLATE_SWITCH_CASE",
        "responseBody": "",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "username = request.getParameter('username');",
        "syncScript": "",
        "asyncScript": "",
        "syncDelay": 0,
        "asyncDelay": 0,
        "start": true,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "哈哈哈1",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-09T10:26:33.000+0000",
        "gmtModified": "2023-03-09T10:32:39.000+0000",
        "responseHeaderList": [],
        "callbackRequestHeaderList": [],
        "branchScriptList": [
          {
            "name": "1",
            "syncScript": "1111111",
            "asyncScript": ""
          },
          {
            "name": "2",
            "syncScript": "222222",
            "asyncScript": ""
          }
        ],
        "path": [
          91,
          92
        ],
        "variable": true
      },
      {
        "requestUri": "/test3",
        "requestMethod": "GET",
        "id": 101,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "GROOVY",
        "responseBody": "",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "",
        "syncScript": "id = request.getParameter('username');\nprint \"ammar11111: \" + id;\nif(id == \"1\"){\n    111111\n} else {\n    222222\n}",
        "asyncScript": "",
        "syncDelay": 0,
        "asyncDelay": 0,
        "start": false,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "哈哈哈",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-09T09:59:35.000+0000",
        "gmtModified": "2023-03-09T10:30:02.000+0000",
        "responseHeaderList": [],
        "callbackRequestHeaderList": [],
        "branchScriptList": [],
        "path": [
          91,
          92
        ],
        "variable": true
      },
      {
        "requestUri": "/test2",
        "requestMethod": "GET",
        "id": 100,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "TEXT",
        "responseBody": "1231",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "",
        "syncScript": "",
        "asyncScript": "",
        "syncDelay": 1000,
        "asyncDelay": 0,
        "start": true,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "test",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-09T09:52:39.000+0000",
        "gmtModified": "2023-03-09T09:52:39.000+0000",
        "responseHeaderList": [
          {
            "name": "ammar",
            "value": "test"
          }
        ],
        "callbackRequestHeaderList": [],
        "branchScriptList": [],
        "path": [
          91,
          92
        ],
        "variable": true
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|object|true|none||none|
|»» page|integer|true|none|页码|none|
|»» itemsPerPage|integer|true|none|每页数量|none|
|»» total|integer|true|none|总数|none|
|»» list|[object]|true|none|接口列表|none|
|»»» requestUri|string|true|none||none|
|»»» requestMethod|string|true|none||none|
|»»» id|integer|true|none||none|
|»»» description|string|true|none||none|
|»»» needAsyncCallback|boolean|true|none||none|
|»»» configMode|string|true|none||none|
|»»» responseBody|string|true|none||none|
|»»» callbackRequestUrl|string|true|none||none|
|»»» callbackRequestMethod|string|true|none||none|
|»»» callbackRequestBody|string|true|none||none|
|»»» branchJumpScript|string|true|none||none|
|»»» syncScript|string|true|none||none|
|»»» asyncScript|string|true|none||none|
|»»» syncDelay|integer|true|none||none|
|»»» asyncDelay|integer|true|none||none|
|»»» start|boolean|true|none||none|
|»»» spaceId|integer|true|none||none|
|»»» lastUpdateUser|string|true|none||none|
|»»» name|string|true|none||none|
|»»» accessAuthority|string|true|none||none|
|»»» gmtCreate|string|true|none||none|
|»»» gmtModified|string|true|none||none|
|»»» responseHeaderList|[object]|true|none||none|
|»»»» name|string|true|none||none|
|»»»» value|string|true|none||none|
|»»» callbackRequestHeaderList|[string]|true|none||none|
|»»» branchScriptList|[object]|true|none||none|
|»»»» name|string|true|none||none|
|»»»» syncScript|string|true|none||none|
|»»»» asyncScript|string|true|none||none|
|»»» path|[integer]|true|none||none|
|»»» variable|boolean|true|none||none|

## POST 检查添加接口是否冲突

POST /mock/http/conflictDetection

> Body 请求参数

```json
{
  "uri": 0,
  "method": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|label|query|string| 是 ||节点名称|
|parentId|query|integer| 是 ||父节点值，根节点为0|
|accessAuthority|query|string| 否 ||节点权限，PUBLIC与PRIVATE|
|level|query|string| 否 ||层级|
|body|body|object| 否 ||none|
|» uri|body|integer| 是 | uri|none|
|» method|body|string| 是 | 请求方法|none|

> 返回示例

> 成功

```json
{
  "resultCode": "0",
  "resultMsg": "成功",
  "data": {
    "page": 1,
    "itemsPerPage": 13,
    "total": 4,
    "list": [
      {
        "requestUri": "/test1111",
        "requestMethod": "POST",
        "id": 103,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "TEXT",
        "responseBody": "{\"resp\":123}",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "",
        "syncScript": "",
        "asyncScript": "",
        "syncDelay": 1000,
        "asyncDelay": 0,
        "start": true,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "test111",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-15T06:14:25.000+0000",
        "gmtModified": "2023-03-15T06:14:25.000+0000",
        "responseHeaderList": [
          {
            "name": "test",
            "value": "emmmm"
          }
        ],
        "callbackRequestHeaderList": [],
        "branchScriptList": [],
        "path": [
          91,
          92
        ],
        "variable": true
      },
      {
        "requestUri": "/test4",
        "requestMethod": "GET",
        "id": 102,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "GROOVY_TEMPLATE_SWITCH_CASE",
        "responseBody": "",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "username = request.getParameter('username');",
        "syncScript": "",
        "asyncScript": "",
        "syncDelay": 0,
        "asyncDelay": 0,
        "start": true,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "哈哈哈1",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-09T10:26:33.000+0000",
        "gmtModified": "2023-03-09T10:32:39.000+0000",
        "responseHeaderList": [],
        "callbackRequestHeaderList": [],
        "branchScriptList": [
          {
            "name": "1",
            "syncScript": "1111111",
            "asyncScript": ""
          },
          {
            "name": "2",
            "syncScript": "222222",
            "asyncScript": ""
          }
        ],
        "path": [
          91,
          92
        ],
        "variable": true
      },
      {
        "requestUri": "/test3",
        "requestMethod": "GET",
        "id": 101,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "GROOVY",
        "responseBody": "",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "",
        "syncScript": "id = request.getParameter('username');\nprint \"ammar11111: \" + id;\nif(id == \"1\"){\n    111111\n} else {\n    222222\n}",
        "asyncScript": "",
        "syncDelay": 0,
        "asyncDelay": 0,
        "start": false,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "哈哈哈",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-09T09:59:35.000+0000",
        "gmtModified": "2023-03-09T10:30:02.000+0000",
        "responseHeaderList": [],
        "callbackRequestHeaderList": [],
        "branchScriptList": [],
        "path": [
          91,
          92
        ],
        "variable": true
      },
      {
        "requestUri": "/test2",
        "requestMethod": "GET",
        "id": 100,
        "description": "",
        "needAsyncCallback": false,
        "configMode": "TEXT",
        "responseBody": "1231",
        "callbackRequestUrl": "",
        "callbackRequestMethod": "",
        "callbackRequestBody": "",
        "branchJumpScript": "",
        "syncScript": "",
        "asyncScript": "",
        "syncDelay": 1000,
        "asyncDelay": 0,
        "start": true,
        "spaceId": 92,
        "lastUpdateUser": "GUEST",
        "name": "test",
        "accessAuthority": "PUBLIC",
        "gmtCreate": "2023-03-09T09:52:39.000+0000",
        "gmtModified": "2023-03-09T09:52:39.000+0000",
        "responseHeaderList": [
          {
            "name": "ammar",
            "value": "test"
          }
        ],
        "callbackRequestHeaderList": [],
        "branchScriptList": [],
        "path": [
          91,
          92
        ],
        "variable": true
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|string|true|none||none|
|» message|string|true|none||none|
|» data|object|true|none||none|
|»» detectable|boolean|true|none|是否可见|none|
|»» conflict|boolean|true|none|是否冲突|none|

# 数据模型

