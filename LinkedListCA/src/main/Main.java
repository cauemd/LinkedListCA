
/*
 *  @Author = Caue Meireles Duarte
 */
package main;

import doublyList.DoublyLinkedList;
import frontPage.FrontPageController;

//Main method, used only to instantiate the front page controller
public class Main {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		new FrontPageController(list);

	}

}
