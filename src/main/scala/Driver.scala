package main

object Driver {
	def main(args: Array[String]) = {
		var list = List(1, 5, 2, 4 ,3)
		println(Sort.mergeSort(list))
	}
}
