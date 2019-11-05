
/*
 *  @Author = Caue Meireles Duarte
 */
package main;

import dbConnector.DbConnector;
import doublyList.DoublyLinkedList;
import doublyList.Node;
import frontPage.FrontPageController;
import person.Person;

//Main method, used only to instantiate the front page controller
public class Main {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		new FrontPageController(list);

	}

}
