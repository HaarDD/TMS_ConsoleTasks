package lesson3;

import base.PrintUtil;
import base.TaskBase;

/*Создать новый проект, запушить его на удалённый репозиторий GitHub. Сделать
несколько коммитов в мастер ветке. Создать отдельную ветку, переключиться на неё и
сделать несколько коммитов. Смержить в мастер ветку. Все последующие решения
Домашних заданий присылать в GitHub(ссылка на репозиторий)*/
public class L3Task1 extends TaskBase {
    public L3Task1() {
        super(1, "Новая ветка git (lesson3)");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        PrintUtil.print("Привет, git!");
    }
}
