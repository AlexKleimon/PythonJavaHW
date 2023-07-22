from func_note import *


def func_notes():
    flag = True
    while flag:
        print("\nСписок команд: add - добавить заметку, del - удалить заметку,"
              " red - редактировать заметку, all - вывести все заметки, "
              "tch - вывести определенную заметку, "
              "tchd - вывести список заметок созданных в определенный день,"
              "exit - выйти из приложения\n"
              "Для того чтобы удалить и отредактировать заметку посмотрите с"
              " помощью команды all весь список заметок и скопируйте дату и "
              "время заметки (Пример: 07/22/23 21:37:32)")
        cmd_note = input("Введите команду: ")
        if cmd_note in "add":
            write_to_json(add_note(input("Введите имя заметки: "),
                                   input("Введите текст заметки: "), 0))
        elif cmd_note in "del":
            del_note(input("Введите дату и время заметки: "))
        elif cmd_note in "red":
            red_note(input("Введите дату и время заметки: "),
                     input("Введите новый текст заметки: "))
        elif cmd_note in "all":
            all_note()
        elif cmd_note in "tch":
            touch_note(input("Введите дату и время заметки: "))
        elif cmd_note in "tchd":
            date_note_pr(input("Введите дату заметок: "))
        elif cmd_note in "exit":
            flag = False
            print("Спасибо что воспользовались Notes! Заходите еще.")
        else:
            print("Такой команды нет.")


func_notes()
