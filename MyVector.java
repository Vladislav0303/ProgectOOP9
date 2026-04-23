import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyVector implements Comparator<Object>, Comparable<Object>{
    public MyVector() {
    Scanner sc = new Scanner(System.in);
        System.out.println("Введіть розмір масиву: ");
        try {
        int size_of_mass = sc.nextInt();
        sc.nextLine();
        int[] mass = new int[size_of_mass * 2];
        for (int i = 0; i < mass.length; i++) {
            while (i < size_of_mass) {
                System.out.println("Введіть значення яке хочете записати в масив: ");
                int el = sc.nextInt();
                sc.nextLine();
                mass[i] = el;
                i++;
                get(mass);
            }
        }
        System.out.println("Введіть число яке хочете додати в кінець масиву: ");
        int el = sc.nextInt();
        Add_Element_In_End(el, mass);
        get(mass);
        sc.nextLine();
        System.out.println("Введіть число який хочете додати в середину масиву: ");
        int el1 = sc.nextInt();
        Add_Element_In_Between(el1, mass);
        get(mass);
        sc.nextLine();
        System.out.println("Введіть число який хочете додати в початок масиву: ");
        int el2 = sc.nextInt();
        Add_Element_In_Start(el2, mass);
        get(mass);
        sc.nextLine();
        Add_Element(mass);
        capasity(mass);
        write_and_read(mass);
        System.out.println("Введіть елемент який хочете видалити за індексом: ");
        int el3 = sc.nextInt();
        Delete_Element(el3, mass);
        get(mass);
        sc.nextLine();
        System.out.println("Хочете видалити весь масив?: ");
        if(sc.nextLine().equals("Так")) {
            Clear_Mass(mass);
        }
        get(mass);
    } catch (
    InputMismatchException e) {
        System.out.println("Не вірно вказано значення");
    }
}
    public void Add_Element_In_End(int el, int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            int end = mass.length / 2;
            mass[end - 1] = el;
        }
    }
    public void Add_Element_In_Between(int el, int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            mass[mass.length / 4] = el;
        }
    }
    public void Add_Element_In_Start(int el, int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            mass[0] = el;
        }
    }
    public void Delete_Element(int el3, int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if(el3 >= mass.length) {
                throw new MyException("Помилка, не вірно вказано індекс");
            }
            mass[el3] = 0;
        }
    }
    public void Clear_Mass(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            mass[i] = 0;
        }
    }
    public void get(int[] mass) {
        System.out.println(Arrays.toString(mass));
    }
    public void write_and_read(int[] mass) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть назву файлу куди хочете записати масив: ");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sc.nextLine()))){
            bw.write(Arrays.toString(mass));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Введіть назву файлу звідки хочете прочитати дані: ");
        try (BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))){
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void capasity(int[] mass) {
        int count = 0;
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] != 0) {
                count++;
            }
        }
        System.out.println("capasity: " + count);
        System.out.println("size: " + mass.length);
        get(mass);
        sort(mass);
        System.out.println("Сортований масив");
        get(mass);
    }
    public void Add_Element(int[] mass) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] == 0) {
                System.out.println("Хочете додати ще елемент якщо масив заповнений?: ");
                if(sc.nextLine().equals("Так")) {
                    System.out.println("Введіть значення яке хочете записати в масив: ");
                    int el4 = sc.nextInt();
                    sc.nextLine();
                    mass[i] = el4;
                    get(mass);
                } else {
                    break;
                }
            }
        }
    }

    public void sort(int[] mass) {
        Arrays.sort(mass);
}
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if(o1.equals(o2)) {
            return 1;
        }
        else {
            return 0;
        }
    }
}