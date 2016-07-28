package com.lynas.app;
public class ProjectFirmaDemo { // Взаимодействие фирм и проектов
    public static void main(String[] args) {
        // Создаем проекты фирм
        FirmProject pr1 = new FirmProject("Festo");
        FirmProject pr2 = new FirmProject("Kepler");
        // в массив args при запуске метода main (String[ ] args)
        // ввели 10 фирм: по 5 для каждой группы.
        int j = 0; // индекс массива args
        // добавление фирм в первый проект
        for (int i = 0; i < 5; i++) {
            int id = Integer.valueOf(args[j]);
            j++; // получен int-эквивалент из String
            String name = args[j];
            j++;
            int rab = Integer.valueOf(args[j]);
            j++;
            // получаем double-эквивалент из String
            double ZP = Double.valueOf(args[j]);
            j++;
            // добавить фирм
            pr1.addFirm(new Firma(id, name, rab, ZP));
        }
        // добавление фирм во второй проект
        for (int i = 0; i < 5; i++) {
            int id = Integer.valueOf(args[j]);
            j++;
            String name = args[j];
            j++;
            int rab = Integer.valueOf(args[j]);
            j++;
            double ZP = Double.valueOf(args[j]);
            j++;
            // добавить фирм
            pr2.addFirm(new Firma(id, name, rab, ZP));
        }
        // Выборка данных
        // Выводим всевозможные списки фирм
        // Выводим основной список без сортировки
        System.out.println("Список фирм участвующих в проекте (без сортировки)");
        pr1.putFirmProject();
        // пытаемся вставить фирм с тем же номером id
        System.out.println("Попытка добавить фирму: 3234, Скворцово, 76, 5000.0");
        pr1.addFirm(new Firma(3234, "Скворцово", 76, 5000.0f));
        // снова выводим основной список
        // (теперь с естественным порядком сортировки)
        System.out.println("Список фирм участвующих в проекте (с естественным порядком сортировки)");
        pr1.putFirmProject();
        // другие списки:
        pr1.aboveAvgZP().sortZPAsc().putFirmProject();
        pr1.betweenZP(3.2f,4.2f).sortZPDesc().putFirmProject();
        // удаление студента по id
        pr1.delFirm(12345);
        //выводим список группы pr1 после удаления студента
        System.out.println ("После удаления студента c id=12345:");
        pr1.putFirmProject();

        // выводим списки студентов для второй группы
        // основной список группы
        pr2.putFirmProject(); // без сортировки
        pr2.sortNameAscZPDesc().putFirmProject(); // с сортировкой по
        // возрастанию фамилии и убыванию балла
        // другие списки:
        pr2.aboveAvgZP().sortZPAsc().putFirmProject();
        pr2.betweenZP(3.2f,4.2f).sortZPDesc().putFirmProject();

        //Проверяем,есть ли во первой группе студент
        // c заданным номером зачетки
        int n=23345;
        Firma s1=pr1.getFirm(n);
        if (s1==null) System.out.println ("В группе "+pr1.getProjectName()+
                " нет студента с номером зачетки "+n);
        else System.out.println(s1);
        n=70000;
        s1=pr1.getFirm(n);
        if (s1==null) System.out.println ("В группе "+pr1.getProjectName()+
                " нет студента с номером зачетки "+n);
        else System.out.println(s1);
        //Проверяем,есть ли во второй группе студент
        // с заданным номером зачетки
        n=53349;
        s1=pr2.getFirm(n);
        if (s1==null) System.out.println ("В группе "+pr1.getProjectName()+
                " нет студента с номером зачетки "+n);
        else System.out.println(s1);

        pr1.UpdateId(34, 24);            //1й метод индивидуального задания
        pr1.Filtr("Бе").putFirmProject();//3й метод индивидуального задания
        pr1.DelObject().putFirmProject();//2й метод индивидуального задания

    } }
