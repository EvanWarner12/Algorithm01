class Sort
{
    void merge(int arr[], int lt, int mid, int rt)
    {
        int low = mid - lt + 1;
        int high = rt- mid;

        int L[] = new int[low];
        int R[] = new int[high];

        int i = 0, x = 0;

        for (i = 0; i < low; i++)
        {
            L[i] = arr[lt + i];
        }
        for (x = 0; x < high; x++)
        {
            R[x] = arr[mid + 1 + x];
        }


        int k = lt;
        i = 0;
        x = 0;

        while (i < low && x < high)
        {
            if (L[i] <= R[x])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[x];
                x++;
            }
            k++;
        }

        while (i < low)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (x < high)
        {
            arr[k] = R[x];
            x++;
            k++;
        }
    }

    void mergeSort(int arr[], int lt, int rt)
    {
        int mid;
        if (lt < rt) {
            mid = (lt + rt) / 2;

            mergeSort(arr, lt, mid);
            mergeSort(arr, mid + 1, rt);

            merge(arr, lt, mid, rt);
        }
    }

    void display(int arr[]) {

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[])
    {
        int arr[] = { 9, 3, 1, 5, 13, 12 };
        Sort ob = new Sort();
        ob.mergeSort(arr, 0, arr.length - 1);
        ob.display(arr);
    }
}

