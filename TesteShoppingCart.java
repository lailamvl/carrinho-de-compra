/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
  }

  @Test
  public void testAddItem() {
    // Escreva aqui seu código de teste

    Item teste1 = new Item("TESTE1", 70.0);
    Item teste2 = new Item("TESTE2", 80.0);

    List<Item> lista= new ArrayList<>();
    lista.add(teste1);
    lista.add(teste2);

    shoppingCart.addItem(teste1);
    shoppingCart.addItem(teste2);
  
    assertEquals(lista, shoppingCart.getItems());

    shoppingCart.removeItem(teste1);
    shoppingCart.removeItem(teste2);

  }

  @Test
  public void testRemoveItem() {
    // Escreva aqui seu código de teste
    Item teste1 = new Item("TESTE1", 70.0);
    Item teste2 = new Item("TESTE2", 80.0);

    shoppingCart.addItem(teste1);
    shoppingCart.addItem(teste2);
    
    shoppingCart.removeItem(teste1);
    shoppingCart.removeItem(teste2);

    for(Item item : shoppingCart.getItems()){
        assertNotEquals(teste1, item);
        assertNotEquals(teste2, item);
      }
    }

  @Test
  public void testGetTotalPrice() {
    // Escreva aqui seu código de teste
    Item teste1 = new Item("TESTE1", 70.0);
    Item teste2 = new Item("TESTE2", 80.0);

    shoppingCart.addItem(teste1);
    shoppingCart.addItem(teste2);

    double DELTA = 0.001;
    assertEquals(150.0, shoppingCart.getTotalPrice(), DELTA);

    shoppingCart.removeItem(teste1);
    shoppingCart.removeItem(teste2);
  }

  @Test
  public void testClearCart() {
    // Escreva aqui seu código de teste
    Item teste1 = new Item("TESTE1", 70.0);
    Item teste2 = new Item("TESTE2", 80.0);

    shoppingCart.addItem(teste1);
    shoppingCart.addItem(teste2);

    shoppingCart.clearCart();
    assertEquals(shoppingCart.getItemCount(), 0);

  }
}
