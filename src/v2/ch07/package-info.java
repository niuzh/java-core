/**
 * 高级AWT
 * 
 * 绘图操作流程:Graphics2D
 * 形状:绘制形状创建一个实现了Shape接口的对象，然后调用Graphics2D类的drow方法。
 * 笔划:定义画笔的样式
 * 着色:Color单色，GradientPaint渐变色，TexturePaint图形重复着色。
 * 坐标变换：将图形上下文中的坐标变换设置为一个比例变换。
 * 剪切:在图形上下文设置一个剪切形状，绘图操作时将限制在剪切形状内。
 * 透明与组合:定义颜色的透明度，和两个形状的组合原则。
 * 绘图提示
 * 图像读取器和写入器
 * 	获取图像问家类型的读取器和写入器
 * 	读入和写出带有多个图像的文件：动画文件带有多个图像。
 * 图像处理
 * 	建立光栅图像
 * 	图像过滤：把图像转化成另一个图像。
 * 打印
 * 	图形打印
 * 	打印多页文件
 * 	打印预览
 * 	打印服务程序：打印文件
 * 	流打印服务程序
 * 	打印属性
 * 剪贴板:消息传递。
 * 	用于数据传递的类和接口
 * 	传递文本：文本的剪贴板操作。
 * 	Transferable接口和数据风格：
 * 	构建一个可传递的图像：通过一个demo演示了剪贴板图像的传递
 * 	通过系统剪贴板传递Java对象
 * 	使用本地剪贴板来传递对象引用
 * 托放操作
 * 	Swing对数据传递的支持
 * 	拖拽源
 * 	放置目标
 * 平台集成
 * 	闪屏：再程序加载完成之前给用户显示一个图片或者窗口。
 * 	启动桌面应用程序：java启动桌面的应用程序，比如打开文件，打开浏览器。
 * 	系统托盘:托盘给用户提示消息。
 * @author niuzhihuan
 */
package v2.ch07;