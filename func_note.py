import json
import datetime


def write_to_json(dc_js):
    with open("note.json") as js_file:
        data = json.load(js_file)
    temp = list(data["Note"])
    temp.append(dc_js)
    data["Note"] = temp
    with open("note.json", "w") as js_file:
        json.dump(data, js_file, ensure_ascii=False, indent=4)
    print("Заметка сохранена!")


def add_note(name, note, index):
    date_ls = ["Дата добавления", "Дата изменения"]
    dict_data = dict()
    dict_data[date_ls[index]] = datetime.datetime.now().strftime(
        "%D %H:%M:%S")
    dict_data[name] = note
    return dict_data


def all_note():
    with open("note.json") as js_file:
        data = json.load(js_file)
    data_note = data["Note"]
    for el in data_note:
        for element in el:
            print(element, ':', el[element])


"""В цикле for по дате находим нужную строку с датой, и после того как выводим
запись добавленой даты делаем следующую итерацию цикла (для вывода аметки)
и с помощью флага flag останавливаем цикл for"""


def touch_note(date_note):
    with open("note.json") as js_file:
        data = json.load(js_file)
    data_note = data["Note"]
    count = 0
    flag = True
    for el in data_note:
        if flag:
            for element in el:
                if count == 1:
                    print(element, ':', el[element])
                    flag = False
                if el[element] in date_note:
                    print(element, ':', el[element])
                    count += 1
        else:
            break


def date_note_pr(date_note):
    with open("note.json") as js_file:
        data = json.load(js_file)
    data_note = data["Note"]
    count = 0
    for el in data_note:
        for element in el:
            if count == 1:
                print(element, ':', el[element])
            count = 0
            if el[element][0:8] in date_note:
                print(element, ':', el[element])
                count += 1


def del_note(date_note):
    with open("note.json") as js_file:
        data = json.load(js_file)
    data_note = list(data["Note"])
    flag1 = True
    msg = "Такой заметки нет. Проверьте дату и время еще раз."
    for i in range(len(data_note)):
        if flag1:
            for element in data_note[i]:
                if data_note[i][element] in date_note:
                    msg = "Заметка удалена!"
                    index = i
                    data_note.pop(index)
                    data["Note"] = data_note
                    with open("note.json", "w") as js_file:
                        json.dump(data, js_file, ensure_ascii=False, indent=4)
                    flag1 = False
                    break
        else:
            break
    print(msg)


def red_note(date_note, note):
    with open("note.json") as js_file:
        data = json.load(js_file)
    data_note = list(data["Note"])
    index = 0
    msg = "Такой заметки нет!"
    count = 0
    flag = True
    for i in range(len(data_note)):
        if flag:
            for element in data_note[i]:
                if count == 1:
                    data_note.pop(index)
                    dict_red = add_note(element, note, 1)
                    data_note.append(dict_red)
                    data["Note"] = data_note
                    with open("note.json", "w") as js_file:
                        json.dump(data, js_file, ensure_ascii=False, indent=4)
                    flag = False
                    msg = "Заметка изменена!"
                elif data_note[i][element] in date_note:
                    index = i
                    count += 1
        else:
            break
    print(msg)
