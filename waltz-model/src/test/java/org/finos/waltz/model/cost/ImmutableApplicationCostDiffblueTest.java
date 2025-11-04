package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableApplicationCostDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationCost.Builder#application(EntityReference)}
   */
  @Test
  void testBuilderApplication() {
    // Arrange
    ImmutableApplicationCost.Builder builderResult = ImmutableApplicationCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.application(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableApplicationCost.Builder#cost(Cost)}
   */
  @Test
  void testBuilderCost() {
    // Arrange
    ImmutableApplicationCost.Builder builderResult = ImmutableApplicationCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cost(new ImmutableCost.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationCost.Builder#from(ApplicationCost)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationCost.Builder builderResult = ImmutableApplicationCost.builder();
    ApplicationCost instance = mock(ApplicationCost.class);
    when(instance.application()).thenThrow(new IllegalStateException("instance"));
    when(instance.cost()).thenReturn(new ImmutableCost.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).application();
    verify(instance).cost();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationCost.Builder#from(ApplicationCost)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationCost.Builder builderResult = ImmutableApplicationCost.builder();
    ApplicationCost instance = mock(ApplicationCost.class);
    when(instance.application()).thenReturn(mock(EntityReference.class));
    ImmutableCost.Json json = new ImmutableCost.Json();
    when(instance.cost()).thenReturn(json);

    // Act
    ImmutableApplicationCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).application();
    verify(instance).cost();
    assertSame(json, builderResult.build().cost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplicationCost#copyOf(ApplicationCost)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationCost instance = mock(ApplicationCost.class);
    when(instance.application()).thenReturn(mock(EntityReference.class));
    ImmutableCost.Json json = new ImmutableCost.Json();
    when(instance.cost()).thenReturn(json);

    // Act
    ImmutableApplicationCost actualCopyOfResult = ImmutableApplicationCost.copyOf(instance);

    // Assert
    verify(instance).application();
    verify(instance).cost();
    assertSame(json, actualCopyOfResult.cost());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationCost#fromJson(ImmutableApplicationCost.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationCost.Json json = new ImmutableApplicationCost.Json();
    ImmutableCost.Json cost = new ImmutableCost.Json();
    json.setCost(cost);
    json.setApplication(mock(EntityReference.class));

    // Act
    ImmutableApplicationCost actualFromJsonResult = ImmutableApplicationCost.fromJson(json);

    // Assert
    assertSame(cost, actualFromJsonResult.cost());
    EntityReference expectedApplicationResult = json.application;
    assertSame(expectedApplicationResult, actualFromJsonResult.application());
  }

  /**
   * Method under test: {@link ImmutableApplicationCost.Json#application()}
   */
  @Test
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationCost.Json()).application());
  }

  /**
   * Method under test: {@link ImmutableApplicationCost.Json#cost()}
   */
  @Test
  void testJsonCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationCost.Json()).cost());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableApplicationCost.Json}
   *   <li>{@link ImmutableApplicationCost.Json#setApplication(EntityReference)}
   *   <li>{@link ImmutableApplicationCost.Json#setCost(Cost)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableApplicationCost.Json actualJson = new ImmutableApplicationCost.Json();
    actualJson.setApplication(null);
    actualJson.setCost(new ImmutableCost.Json());

    // Assert
    Cost cost = actualJson.cost;
    assertTrue(cost instanceof ImmutableCost.Json);
    assertNull(((ImmutableCost.Json) cost).costKind);
    assertNull(((ImmutableCost.Json) cost).amount);
    assertNull(((ImmutableCost.Json) cost).kind);
    assertNull(actualJson.application);
    assertEquals(0, ((ImmutableCost.Json) cost).year);
    assertFalse(((ImmutableCost.Json) cost).yearIsSet);
  }
}
