/**
 * 安全：类如何加载，加载后字节码如何校验，安全与权限，认证，签名，最后介绍加密。
 * 类加载器：Java编译器会为虚拟机转换机器指令。
 * 	类加载器的层次结构
 * 	将类加载器作为命名空间:类是由它的全名和类加载器来确定的。
 * 	编写你自己的类加载器
 * 字节码校验:类字节码传递给虚拟机时，字节码将接受校验器校验。通过一个16进制编辑器修改字节码文件演示虚拟机校验。
 * 安全管理器与访问权限：安全管理器是一个负责控制具体操作是否允许的类。
 * 	Java平台安全性:建立了代码来源和访问权限之间的映射关系。
 * 	安全策略文件：文件包含了将代码来源映射为权限的指令。
 * 	定制权限
 * 	实现权限类:在方法中增加权限类
 * 用户认证:认证负责确认使用者身份。
 * 数字签名
 * 	消息摘要：是数据块的数据指纹。
 * 	消息签名
 * 	校验签名
 * 	认证问题
 * 	证书签名
 * 	证书请求
 * 代码签名
 * 	JAR文件签名
 * 	软件开发者证书
 * 加密
 * 	对称密码
 * 	密钥生成
 * 	密码流：对流数据进行自动加密解密
 * 	公共密钥密码
 * @author niuzhihuan
 */
package v2.ch09;