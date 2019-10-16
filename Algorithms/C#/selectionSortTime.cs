using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Threading.Tasks;

namespace Algo
{
    class Program
    {
        public void Test(int[] arr)
        {
            for ( int x = 0; x < arr.Length; x++)
            {
                Console.Write(arr[x] + " ");
            }
            Console.Write("\n");
        }

        public int[] selectionSort(int[] arr)
        {
            int tmp, min;
            for (int i = 0; i < arr.Length - 1; i++)
            {
                min = i;
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[j] < arr[min])
                    {
                        min = j;
                    }
                }
                tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
            return arr;
        }

        public int[] genArray(int size)
        {
            Random randomGen = new Random();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++)
            {
                arr[i] = randomGen.Next();
            }

            return arr;
        }

        static void Main(string[] args)
        {
            bool state = true;
            string filePath = @"C:\Users\User\Desktop\AlgoComplexTime.csv";
            var csvData = new StringBuilder();
  

            try
            {
                while (state)
                {
                    Program prog = new Program();


                    int arraySize;
                    Console.Write("Enter array size :");
                    string inp = Console.ReadLine();
                    if (inp == "exit") { state = false; break; }
                    arraySize = Int32.Parse(inp);
                    int[] arr = prog.genArray(arraySize);
                    DateTime stTime = DateTime.Now;
                    prog.selectionSort(arr);
                    DateTime endTime = DateTime.Now;
                    var t = (endTime - stTime).TotalMilliseconds;
                    var newLine = string.Format("{0},{1}", inp, t);
                    csvData.AppendLine(newLine);
                    
                    Console.WriteLine("Time Taken : " + t);
                    Console.WriteLine("Enter 'exit' save file and exit the program.");
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("exception : " + e.Message);
            }
            finally
            {
                File.AppendAllText(filePath, csvData.ToString());
                Console.WriteLine("Saved File");
                Console.ReadKey();
            }

        }

    }
}
