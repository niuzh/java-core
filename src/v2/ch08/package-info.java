/**
 * JavaBean构件：一个Bean就是一个可重用的UI构件，并且能够在开发工具中可视化的操作。
 * 为何使用Bean：JavaBean技术是为了在UI驱动类程序具备竞争力而开发的，以最小的编程量来完成Java用户界面组件化开发。
 * 编写Bean的过程
 * 使用Bean来构造应用程序：Bean文件打包之后在IDE环境导入
 * 	将Bean打包成JAR文件
 * 	在开发环境中组合Bean
 * Bean属性与事件的命名模式
 * Bean属性的类型
 * 	简单属性
 * 	索引属性
 * 	绑定属性：属性改变时激发事件
 * 	约束属性：受到某种约束，监听器可以否决改变，还原旧值。
 * BeanInfo类：用来识别对应的Bean类具有的特性。
 * 属性编辑器
 * 定制器
 * JavaBean持久化:用JavaBean的属性将bean存储在流中，或从流中读取，类似与对象序列化。
 * 	JavaBean持久化可用于任何数据
 * 	一个JavaBean持久化的完整示例
 * @author niuzhihuan
 */
package v2.ch08;