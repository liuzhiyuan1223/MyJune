package com.june.generics_kotlin

class Generics<T> {

    val i: Int = 3;

    private val t: T? = null

    fun <R> getResult(): R? {
        return null
    }


    private fun test1() {
        //kotlin
        abstract class Source<out T> {
            abstract fun nextT(): T
        }

        fun demo(oranges: Source<Orange>) {
            val fruits: Source<Fruit> = oranges // 没问题，因为 T 是一个 out-参数，Source<T>是协变的
            val oneFruit: Fruit = fruits.nextT() //可以安全读取
        }


        val list1: List<out Fruit> = listOf(Orange())
        val get = list1.get(5)

        val list2: MutableList<Fruit> = mutableListOf()
    }


    //测试代码
    fun copy(from: Array<Any>, to: Array<Any>) {
        assert(from.size == to.size)
//
//        for (i in from.indices) {
//            to[i] = from[i]
//        }
    }

    open class Fruit {
    }

    class Orange : Fruit() {
    }


    public interface Collection<out E> : Iterable<E> {
        public val size: Int
        public fun isEmpty(): Boolean
        public operator fun contains(element: @UnsafeVariance E): Boolean
        override fun iterator(): Iterator<E>
        public fun containsAll(elements: Collection<@UnsafeVariance E>): Boolean

        fun demo(oranges: Collection<Orange>) {
            val fruits: Collection<Fruit> = oranges
        }
    }




    fun cost(block : () -> Unit, i : Int){
        block.invoke()
    }

    fun tes1() {
        cost(
            { print("") }, 5
        )
    }

}
