# java-learning


###day 03
1. "" + 基本类型，执行字符串转换
2.  按位与“&” 、按位或“|”、逻辑与“&&”、逻辑或“||”
3. 截尾和舍入：float 和 double在转换为int时总是会被截尾，舍入要用Math.round()
4. 表达式中出现的最大数据类型决定了表达式结果的数据类型
5. 所有基本类型的大小是确定的
6. 布尔值不能相加，以及进行其他任何操作（包括不能转换成其他的基本数据类型）
7. Java中唯一用到逗号操作符的地方就是for循环的初始化和布进部分
8. foreach (a)任何一个返回数组的方法都可以使用foreach (b）foreach可以用于任何Iterable对象
9. 由goto想到：通过限制语言的能力，反而能使一项语言特性更加有用
10. 把一个int型当做字符打印需要先转成char,否则会输出一个整数
11. 斐波那契数列：每一个数都是前两个数的和。前5个数为：1、1、2、3、5
12. 吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序。
   以两个0结尾的数字是不允许的，例如，下列数字都是“吸血鬼”数字：
   1260 = 21 * 60 　1827 = 21 * 87 　2187 = 27 * 81
   4位数的吸血鬼数有7个：
   1260, 1395, 1435, 1530, 1827, 2187, 6880

###day 04
1. 构造器没有返回值
2. 每个重载的方法都要有一个独一无二的参数类型列表
3. 涉及基本类型的重载：(a)如果传入的数据类型（实际参数类型）小于方法中声明的形式参数类型，实际数据类型就会被提升。char型略有不同，如果找不到恰好接受char类型参数的方法，就会把char型直接提升为int型
    (b)如果传入的实际参数类型较大，就得通过类型转换来执行窄化转换，如果不这样做，编译器会报错。
4. 不能通过返回值区分重载方法
5. this 代表对“调用方法的那个对象”的引用
6. this(...) 表示调用不同参数类型的构造器，而且只能在构造器调用另一个构造器。
7. 当参数s的名称和数据成员s的名字相同时，会产生歧义，使用this.s 来表示数据成员就能解决这个问题
8. 对象可能不会被垃圾回收
9. 因为对象被清理前都会调用一次finalize()方法，所以可以重写finalize()来验证对象被清理的时候是否符合条件
10-a. 从栈和静态储存区出发，追踪所有的引用，找到和引用连接的所有存活的对象，直到整个网络结束。
10-b. 自适应的、分代的、停止-复制、标记-清扫式垃圾回收器
11. 无法阻止自动初始化的进行，他将在构造器被调用之前进行
12. 在类的内部，变量定义的顺序决定了初始化的顺序。所有变量的初始化会在任何方法调用之前（包括构造器）完成
13. 静态变量初始化和非静态变量初始化的值没什么区别，静态变量只会在首次用到类的时候初始化一次
14. 初始化的顺序是先静态对象，然后是"非静态"对象
15. 使用实例初始化，可以保证无论调用哪个构造器都执行某些变量的初始化,而且实例初始化也会在构造器调用之前执行
16. 对象数组创建后，如果没有给里面的元素赋值就使用的话，会得到运行时异常
17. 如果已有一个数组，可以把它当做可变参数列表来接受
18. 将0个参数传递给可变参数列表是可行的
19. 如果有必要，可变参数列表会自动执行包装转换
20. enum 可以用于switch语句中

###day 05
1. 作为一名类库设计员，你会尽可能把一切方法都设计成private，只向客户端程序员公开你希望他们使用的方法
2. 一个java源文件，可以说是一个编译单元，一个编译单元只可以有一个public类，如果有另外的类，另外的类仅仅包内可见
3. CLASSPATH包含一个或多个文件，用来查找.class文件的根目录。从根目录开始，解释器会寻找创建类用到的.class文件，在这过程中，寻找包的时候会把所有.号都替换成/或者\。例如foo.bar.baz会变成foo/bar/baz
4. CLASSPATH在使用jar文件的时候会有点不同，必须指定jar文件的名字  CLASSPATH = C:\color\red.jar
5. 在使用有冲突的名字的情况下，必须返回到指定类的全名  List ...   java.util.List...
6. 条件编译：用于调试，调试是对开发版开放的，对发布版关闭的。可以通过修改被导入的package来实现，具体来说就是将代码从开发版切换到发布版
7. 提供get/set方法访问和改变数据，是最优雅的方式，也是JavaBeans的基本原理
8. default 默认是包访问权限，如果这时候发生继承，那么子类也是没办法使用父类中default 成员的，只能使用protected 成员（如果父类和子类不在同一个包中的话）
9. 访问权限控制将权限划分在数据类型的内容。 意义：1.设定客户端程序员可以使用和不可以使用的边界。 2.接口和实现分离，类设计者可以随意改动非public的成员，而不会对客户端的使用造成影响
10. 类的复用包括组合 和 继承
11. 惰性初始化，在正要使用这些对象之前进行初始化
12. 每创建一个类，总是在继承，不是显式继承，就是隐式继承Object
13. 当继承发生后，派生类会自动得到基类所有的（public）域和方法
14. 即使一个类只有包访问权限，public main() 仍是可以访问的
15. 继承规则：将所有的数据成员设为private，将所有方法设为public
16. super.xxx() 将调用基类的 xxx() 版本
17. 当创建一个导出类对象的时候，该对象包含一个基类的子对象。这个子对象和新建的基类对象没有什么区别。只是一个在外部，一个在导出类的内部。
18. 构建是从基类向外扩散的，所有基类在导出类初始化之前就已经完成了初始化。
19. 如果没有默认的基类构造器，或者想要调用一个带参数的基类构造器，那么就需要使用super()来显式调用，并配以适当的参数列表。
20. 代理：组合会把成员对象的所有方法暴露给组合后的对象，代理可以解决这个问题
21. 基类的清理要和构建的顺序相反，保证基类存活到最后

###day 06
1. override 重载发生在继承关系中，必须保证父类和子类的返回值，方法参数列表都一致，可以用@Override 注解检验子类中的方法是否正确重载。和重载对应的是覆写，覆写允许返回值和参数列表不同。
2. 继承和组合的选择：(a)组合是嵌入一个对象，你要了解的是新对象的接口，而不是嵌入对象的。继承是使用某个现有类，并开发一个它的特殊版本。 (b)组合是has-a，继承是is-a
3. 继承的一个重要功能是可以用于转型，Wind也是一种Instrument
3. 向上转型是从较专用的类型转为较通用的类型，所以是安全的
4. 判断使用组合还是继承：是否需要从新类向基类向上转型
5. 即使向上转型了，调用方法的时候还是会优先使用的导出类对象中重载的方法
6. final和static一起表示一段不可改变的储存空间
7. final :对于基本类型，使数值恒定不变；对对象，使引用恒定不变，也就是这个引用不能再指向别的对象，但改对象是可以变的
8. 使引用成为final没有使基本类型成为final作用大
9. final方法：确保在继承中使方法行为保持不变，且不会被覆盖
10. 类的代码在初次使用时被加载，通常是指创建类的对象的时候，但是当访问static域或static方法的时候，加载也会发生
11. 启动类名.main()方法也会导致类被加载，所有的static成员也会随之加载
12. 多态:也称动态绑定，运行时绑定，后期绑定
13. 在面向对象的程序设计语言中，多态是数据抽象和继承之后的第三种基本特征
14. 多态通过分离做什么和怎么做，从另一个角度将接口和实现分离开来
15. 把一个方法和调用这个方法的主体联系起来叫做绑定。前期绑定：在程序执行前进行绑定，一般由编译器和连接程序进行。后期绑定：运行时根据对象类型来绑定。
16. 通过一个导出类对象调用方法时，会先在导出类中找，如果没有，会去基类找，如果有，会调用导出类中的方法。可以通过this的作用域理解
17. 多态中，调用方法前，使用的是前期绑定，必须是基类有的方法才可以调用，而且如果这个方法是private的，也就不能被重载，也就是不能调用到导出类的同名方法，即使用的是导出类对象。所以基类和导出类的方法最好不要重名
18. 域和静态方法：多态只在普通方法调用时生效，如果直接访问某个域，这个访问会在编译时就进行解析。如果某个方法时静态的，那么它的行为不具有多态性。因为静态方法是与类，而非与单个对象相关联的。
19. 复杂对象调用构造器规则： 1.调用基类构造器，这个步骤会一直递归下去，然后是下一层导出类。 2.按声明的顺序调用成员的初始化方法 3.调用导出类的构造器的主体。所以类加载做的第一件事是加载父类，第二步才是初始化成员。
20. 上面构造器调用的规则并不准确，在其他任何事物发生之前，将分配给对象的存储空间初始化伟二进制的0，所以在导出类调用构造器时，如果在基类构造器中调用导出类中覆盖的方法，会导致导出类中的成员还没初始化，而只有初始值
21. 编写构造器的一条有效准则：用尽可能简单的方法使对象进入正常状态，如果可以的话，避免调用其它方法。
22. 在构造器中唯一能够安全调用的方法是基类中的final方法。这些方法不能被覆盖，因此就不会出现上面的问题。

###day 07
1. 组合更加灵活，因为可以动态改变类型（引用在运行时可以动态和一个新对象绑定起来），而继承是在编译时就需要确定类型。一条通用的准则：用继承表达行为的差异，用字段表达状态的上的变化。
Actor的例子中，通过继承得到了两个不同的类，用于表达act()方法的差异，而Stage通过运用组合使自己的状态发生变化，这种状态的改变也导致了行为的改变。
2. 导出类中扩展的部分不能被基类访问，所以在向上转型后不能调用那些接口
3. downcast 和 运行时类型识别（RTTI） 和 ClassCastException 类型转换异常
4. 接口和内部类为我们提供了一种将接口和实现分离的更加结构化的方法
5. 包含一个或多个抽象方法的类必须是抽象的，否则，编译器会报错。如果从一个抽象类继承，并想创建该新类的对象，那么就需要对基类中所有的抽象方法进行定义，否则导出类也会被限定为抽象类。
6. (a)创建抽象类和抽象方法非常有用，因为它们可以使类的抽象性明确起来，并告诉用户和编译器打算怎么使用它们。 
   (b)抽象类还是很有用的重构工具，因为它可以使我们很容易地将公共方法沿着继承层次结构向上移动（也就是把公共方法尽量抽象到最高基类中）
7. 一个接口表示：所有实现了该特定接口的类看起来都像这样。所以接口可以用来建立类与类之间的协议。
8. 接口也可以包含域，但是这些域隐式是static 和 final 的
9. 接口中的方法默认是public的，当实现一个接口时，方法也必须是public的，否则就只有包权限，所以在继承关系中这会导致权限下降，这是java编译器不允许的。
10. 策略设计模式：创建任何类型的Processor，并应用在一个Object上，这种创建一个能够根据传入参数对象的不同而具有不同行为的方法，被称为策略设计模式。
    这类方法中包含所使用算法中固定不变的部分，而策略包含变化的部分。策略就是传递进去的参数对象，它包含要执行的代码。在这里，Processor就是一个策略。
11. filter 和 Apply 具有相同的接口元素，这时候应该复用Apply.process()的代码，但是因为filter没有继承Processor(不知道要这么做)，所以不能复用。
    主要的原因是Apply.process()和Processor 耦合太紧，超出所需的程度，所以复用被禁止了。解决的办法就是把Processor做成接口。
12. 适配器中的代码会接受你所拥有的接口（Processor)，产生你所需要的接口。根本上是通过把Filter作为成员组合进来，然后在调用process()的时候间接调用Filter中的process()实现的。
    这种设计可以使用到Processor接口的所有代码都可以用于这个适配器，然后到Filter中执行。

###day 08
1. 适配器模式的第二种方式：通过继承复用其中一个类，通过实现接口使该适配器可以传递给用到该接口的方法，再在该接口的实现方法中调用复用了继承类中的方法来实现具体逻辑。
2. 接口中的域不是接口的一部分，它们的值存储在该接口的静态存储区域内（因为默认是static 和 final的）。静态区（也叫方法区）：跟堆一样，被所有的线程共享。方法区包含所有的class和static变量。
3. 工厂方法设计模式：生成遵循某个接口的对象。更加优雅的工厂实现方式，使用匿名内部类。
4. 可以将一个类的定义放在另一个类的定义的内部，这就是内部类。内部类和组合是完全不同的概念。
5. 迭代器设计模式：创建一个接口，然后用一个内部类来实现这个接口，之后就可以在外部类中调用这个接口中的方法来操作自己的成员。
6. 在内部类中，如果想要获取外部类对象，可以用 (类名 + .this) 获取
7. 要创建内部类对象，必须通过 (外部类对象.new 内部类类名) 的方法创建。如果创建的是嵌套类（静态内部类），那么就不需要外部类对象的引用。
8. 可以在一个方法内部或是任意作用域内创建内部类。这样做的方法有两个，一：实现某个接口，使用该接口的方法  二：希望用一个类辅助解决问题，又不希望这个类是公共可用的
9. 可以在方法的返回一个匿名内部类的同时对这个类进行定义，这种奇怪的语法实际指的是创建一个继承这个类的对象并向上转型。
10. 当在方法里面使用匿名内部类返回时，而且匿名内部类使用参数时，外部传进来的参数必须使用final修饰
11. 声明为static的内部类，常常被称为嵌套类。内部类的对象和外部类对象之间没有关系。要创建内部类对象，不需要外部类对象；要获取外部类对象（非静态），也不能通过嵌套类获取。
12. 普通内部类的字段和方法，只能放在类的外部层次上，所以普通的内部类不能有static数据和static字段（也就是类不是static的，里面的成员也不能是static的）。但是嵌套类可以。
13. 在一个普通的（非static)内部类中，通过一个特殊的this引用可以链接到其外围类对象（外部类类名.this）。嵌套类就没有这个特殊的this引用，这使得它类似于一个static方法。
14. 一个内部类被嵌套多少层并不重要--它能透明地访问所有它嵌入的外围类的所有成员，即使外围类的成员是private的


###day 09
1. 为什么需要内部类：一般来说，有两种用途。内部类继承一个类或是实现某个接口；内部类的代码操作创建它的外围类对象。所以可以认为内部类提供了某种进入外部类的窗口。
2. 内部类多重继承：每个内部类都能独立继承或实现一个接口，所以无论外围类是否继承或实现某个接口或类，对于内部类都没有影响。
   如果要在一个类中实现多个接口，可以用单一类，也可以使用内部类。如果是抽象的类或是具体的类，而不是接口，就只有内部类可以实现多重继承。
3. 内部类Closure实现了Incrementable,以提供一个返回Callee2的钩子，而且这个钩子是绝对安全的（因为内部类保存着外部类的引用）
4. 设计模式总是把变化的事物和不变的事物分离开。
5. 局部内部类不能有访问说明符，因为它不是外围类的一部分，但是它可以访问当前代码块内的常量，以及此外围类的所有成员。
6. 局部内部类和匿名内部类的区别：局部内部类可以使用一个命名的构造器，或者需要重载的构造器，而匿名内部类只能用于实例初始化，所以使用局部内部类而不是匿名内部类的另一个理由是：需要不止一个该内部类对象。


###day 10
1. 容器类使用泛型，可以把运行时异常改为编译时错误，这样更加明显地发现错误。而且从中取元素的时候，类型转换也是不必要的了。
2. 可以将子类放到基类的容器中，向上转型是可行的。
3. Arrays.asList转化出来的List底层是数组，所以长度是固定的，不能增加或删除元素
4. 要打印toString()内容: 数组必须使用Arrays.toList()，但是打印容器不用额外做处理 (容器提供的toString())。
5. Queue 队列，只允许从容器的一端插入对象，从另外一端移除对象
6. Set 是最快的获取元素的方式，存储的顺序往往是无序的。TreeSet 按照比较结果的升序保存对象，LinkedHashSet根据被添加的顺序保存对象(Map也一样)。Set 不会保存重复的元素。
7. List:以特定序列保存元素。一般有两种：ArrayList-随机访问效率高，在中间插入或删除效率低。LinkedList-在中间插入或删除效率高，随机访问效率低。
8. List 的remove()不能通过创建一个和容器中想要删除元素同类型的对象，再通过这个对象删除容器中同类型的元素。且调用indexOf 会返回-1。
   所产生的行为与equals()有关。如果为true, 那么将成功删除，并且返回正确的第一个索引。
9. add(index, pojo) 会在索引=3的位置，也就是第四个位置插入该元素，并且把之前3位置及其之后的元素往后移一格。addAll(index, List) 也是同样的道理。
10. subList(start, end) 会在start开始，在end-1处停止
11. Collections.shuffle(list, random) 根据源随机打乱一个列表
12. List.retainAll(new list) 只保留new list中包含的元素，而且如果源列表有多个，也只会保留一个。所产生的行为与equals()有关。
13. removeAll(list) 只会删除特定的元素，如果元素是相同类型的，只会删除一个。所产生的行为与equals()有关。
14. List 转数组：List.toArray(new Pet[0]) 加上new Pet[0]可以转为指定类型的数组，否则默认是Object[]
15. set(index, pojo) 在该索引位置，用该pojo替换原来的pojo
16. isEmpty 和 clear: 判断为空以及清除列表元素
17. Iterator 迭代器，它的作用是遍历并选择序列中的对象。能够将遍历序列和序列底层的结构分离，可以说迭代器统一了对容器的访问方式。
18. Iterator 可以移除next()产生的最后一个元素，这意味着remove()之前必须先调用next()
19. listIterator() 可以用来返回一个带有索引的迭代器，这个迭代器是Iterator的子类，它可以获得前一个和后一个的索引。
20. 使用listIterator() 获取倒序列表，需要先遍历一遍并完整调用next(),使cursor移动到最后的位置，然后通过listIterator.previous()按顺序从后到前获取元素。
    https://www.cnblogs.com/TianyuSu/p/9467081.html
21. listIterator(n) 获取一个从指定索引处开始迭代的迭代器。
22. listIterator.set(pojo) 调用next() 或 previous() 后设置获得的最后一个元素为新的对象  
23. LinkedList: 
    不移除元素：getFirst(异常) = peek(null)、getLast(异常)；
    移除元素：remove(异常) = removeFirst(异常) = poll(null)、removeLast(异常) ；
    添加元素：add = addLast = offer、addFirst
    判空：isEmpty()
24. 栈：后进先出，在头部添加，在头部移除。可以直接用linkedList实现。栈在编程语言中常常用来对表达式求值。
25. Set: HashSet 使用了散列，LinkedHashSet 使用了散列，另外使用了链表来维护元素的插入顺序， TreeSet 使用了红黑树的数据结构
26. 队列：先进先出，从一端添加元素（尾部），从另一端取出（头部）。可以直接用linkedList实现。linkedList实现了Queue接口，所以可以向上转型为Queue。
27. PriorityQueue: 优先队列，通过制定优先级顺序，使队列根据该优先级顺序弹出元素。使用到了Comparator。
28. 生成Iterator是将队列和消费队列的方法连接在一起耦合度最小的方式，并且与实现Collection相比，它在序列类上所施加的约束也少很多。
    因为如果继承AbstractCollection就不能继承别的类了。
29. 任何实现Iterable接口的类，都可以使用foreach遍历。
30. 尝试把数组传给一个Iterable引用是不可行的，这说明不存在任何的从数组到Iterable的自动转换，必须先手动执行转换为Collection。
31. Arrays.asList() 产生的List对象会使用底层数组作为其物理实现，只要你执行的操作都会修改这个数组。
    如果不想数组元素被改变，应该创建一个副本，比如把产生的对象传递给一个Collection的构造器。
32. ArrayList实现了一个叫做 RandomAccess 的接口，而 LinkedList 是没有的。
    RandomAccess 是一个标志接口，表明实现这个这个接口的 List 集合是支持快速随机访问的。也就是说，实现了这个接口的集合是支持 快速随机访问 策略的。  
