package lesson3;

import base.ConsoleUtil;
import base.Runnable;

/*Создать новый проект, запушить его на удалённый репозиторий GitHub. Сделать
несколько коммитов в мастер ветке. Создать отдельную ветку, переключиться на неё и
сделать несколько коммитов. Смержить в мастер ветку. Все последующие решения
Домашних заданий присылать в GitHub(ссылка на репозиторий)*/
public class L3Task1 extends Runnable {
    public L3Task1() {
        super("Новая ветка git (lesson3)");
    }

    @Override
    public void run() {
        ConsoleUtil.println("Привет, git! (lesson3)");
    }
}
