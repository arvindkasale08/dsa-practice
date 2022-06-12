#include <iostream>
using namespace std;

void swap(int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}


int partition(int array[], int start, int end) {
    
    int pivot = array[end];
  
    int i = (start - 1);

    for (int j = start; j < end; j++) {
        if (array[j] <= pivot) {        
            i++;
            swap(&array[i], &array[j]);
        }
    }
  
    swap(&array[i + 1], &array[end]);
    return (i + 1);
}

void quickSort(int array[], int start, int end) {
    if (start < end) {
      
        int pi = partition(array, start, end);

        quickSort(array, start, pi - 1);
        quickSort(array, pi + 1, end);
    }
}

int main() {
    int arr[] = {8, 7, 6, 1, 0, 9, 2};
    int size = sizeof(arr) / sizeof(arr[0]);
  
    quickSort(arr, 0, size - 1);
  
    for (int i = 0; i<size; i++){
        cout << arr[i] << "\n";
    }

    return 0;
}