
/*
 *  @Author = Caue Meireles Duarte
 */
package main;

import dbConnector.DbConnector;
import doublyList.DoublyLinkedList;
import frontPage.FrontPageController;
import person.Person;

//Main method, used only to instantiate the front page controller
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList list = new DoublyLinkedList();
		new FrontPageController(list);
		//new DbConnector();
	}

}
