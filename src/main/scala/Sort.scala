package algorithms

object Sort {

	//Merge Sort
    def mergeSort(arry: List[Int]): List[Int] = {
        if (arry.length == 1) return arry
        val (left, right) = arry.splitAt(arry.length/2)
        merge(mergeSort(left), mergeSort(right))
    }

    def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
        case(Nil, right) => right
        case(left, Nil) => left
        case (hL::tL, hR::tR) => {
            if (hL < hR) hL::merge(tL, right)
            else hR::merge(left, tR)
        }
    }

    //Quick sort
    def quickSortHalfPivot(list: List[Int]): List[Int] = {
        if (list.length < 2) return list
        val pivot = list(list.length/2)
        quickSort(list.filter (_ < pivot)) ++ quickSort(list.filter (_ == pivot)) ++ quickSort(list.filter (_ > pivot))
    }

    def quickSortLinearPivot(list: List[Int]): List[Int] = list match {
        case(Nil) => Nil
        case(h::t) =>
            var (left, right) = t.partition(_ < h)
            quickSort(left) ++ (h::quickSort(right))
    }
}

