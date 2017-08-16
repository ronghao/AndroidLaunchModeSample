# [AndroidLaunchModeSample](https://github.com/ronghao/AndroidLaunchModeSample)


## 参考文档
+ [https://developer.android.com/guide/components/tasks-and-back-stack.html](https://developer.android.com/guide/components/tasks-and-back-stack.html)
+ [https://developer.android.com/reference/android/content/Intent.html#FLAG_ACTIVITY_CLEAR_TASK](https://developer.android.com/reference/android/content/Intent.html#FLAG_ACTIVITY_CLEAR_TASK)


## 场景
+ standard
    + 
+ singleTop
    + 搜索功能
        + 搜索功能默认页面，调到收缩结果页面，不会top叠加，不发生跳转，但执行搜索功能返回数据通过onNewIntent返回
    + 接收通知启动的内容显示页面
+ singleTask
    + 作为程序入口点，只会启动主界面一次，其余情况都会走onNewIntent，并且会清空主界面上面的其他页面
+ singleInstance
    + 适合需要与程序分离开的页面
    + 不要用于中间页面

## 结论

+ standard 
	+ 默认标准的启动模式
	+ 点击顺序 1->2->3->1
	+ 任务栈  [栈顶]1[栈底]->[栈顶]21[栈底]->[栈顶]321[栈底]->[栈顶]1321[栈底]
+ singleTop
	+ 单一顶部
	+ 点击顺序 1->2->3->3
	+ 任务栈  [栈顶]1[栈底]->[栈顶]21[栈底]->[栈顶]321[栈底]->[栈顶]321[栈底]
	+ 栈顶为3，不会创建新的activity3,**会调用onNewIntent**
+ 
	+ 单一任务栈
	+ 没有设置taskAffinity
		+ 点击顺序 1->2->3->2
		+ 任务栈  [栈顶]1[栈底]->[栈顶]21[栈底]->[栈顶]321[栈底]->[栈顶]21[栈底]
		+ 最后一步，2Activity已存在与任务中，系统会调用 **onNewIntent()**向其传值，其顶部Activity会被推出
	+ 当设置了taskAffinity，而且要启动的activity的taskAffinity 以前没有被创建过，则新建一个task存储Activity
		+ 点击顺序 1（taskAffinity  task1）->2（taskAffinity  task2）->3（taskAffinity  task3）->2（taskAffinity  task2）
		+ 任务栈  [栈顶]1[栈底]->[栈顶]2[栈底][栈顶]1[栈底]->[栈顶]3[栈底][栈顶]2[栈底][栈顶]1[栈底]->[栈顶]2[栈底][栈顶]3[栈底][栈顶]1[栈底]
+ singleInstance
	+ 单一实例
	+ 点击顺序 1->2
	+ 任务栈  [栈顶]1[栈底]->[栈顶]2[栈底][栈顶]1[栈底]