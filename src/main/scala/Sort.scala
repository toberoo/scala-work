package algorithms

object Sort {

	//Merge Sort
    def mergeSort(arry: List[Int]): List[Int] = {
        if (arry.length == 1) return arry
        val (left, right) = arry.splitAt(arry.length/2)
        return merge(mergeSort(left), mergeSort(right))
    }

    def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
        case(Nil, right) => right
        case(left, Nil) => left
        case (hL::tL, hR::tR) => {
            if (hL < hR) return hL::merge(tL, right)
            return hR::merge(left, tR)
        }
    }

    //Quick sort
    def quickSort(list: List[Int]): List[Int] = {
        if (list.length < 2) return list
        val pivot = list(list.length/2)
        quickSort(list.filter (_ < pivot)) ++ 
        quickSort(list.filter (_ == pivot)) ++ 
        quickSort(list.filter (_ > pivot))
    }
}

