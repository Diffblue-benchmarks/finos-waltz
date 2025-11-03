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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.cost.ImmutableApplicationCost.Builder;
import org.finos.waltz.model.cost.ImmutableCost.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationCostDiffblueTest {
  /**
   * Test Builder {@link Builder#application(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#application(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder application(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.application(EntityReference)"})
  void testBuilderApplication_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.application(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#cost(Cost)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#cost(Cost)}
   */
  @Test
  @DisplayName("Test Builder cost(Cost); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cost(Cost)"})
  void testBuilderCost_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cost(new Json()));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationCost)}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   *   <li>Then builder build cost is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationCost)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationCost); given EntityReference; then builder build cost is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationCost)"})
  void testBuilderFrom_givenEntityReference_thenBuilderBuildCostIsJson() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();
    ApplicationCost instance = mock(ApplicationCost.class);
    when(instance.application()).thenReturn(mock(EntityReference.class));
    Json json = new Json();
    when(instance.cost()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).application();
    verify(instance).cost();
    assertSame(json, builderResult.build().cost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationCost)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationCost)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationCost); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationCost)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();
    ApplicationCost instance = mock(ApplicationCost.class);
    when(instance.application()).thenThrow(new IllegalStateException("instance"));
    when(instance.cost()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).application();
    verify(instance).cost();
  }

  /**
   * Test Json {@link ImmutableApplicationCost.Json#application()}.
   * <p>
   * Method under test: {@link ImmutableApplicationCost.Json#application()}
   */
  @Test
  @DisplayName("Test Json application()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference ImmutableApplicationCost.Json.application()"})
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationCost.Json()).application());
  }

  /**
   * Test Json {@link ImmutableApplicationCost.Json#cost()}.
   * <p>
   * Method under test: {@link ImmutableApplicationCost.Json#cost()}
   */
  @Test
  @DisplayName("Test Json cost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Cost ImmutableApplicationCost.Json.cost()"})
  void testJsonCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationCost.Json()).cost());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableApplicationCost.Json}
   *   <li>{@link ImmutableApplicationCost.Json#setApplication(EntityReference)}
   *   <li>{@link ImmutableApplicationCost.Json#setCost(Cost)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableApplicationCost.Json.<init>()",
      "void ImmutableApplicationCost.Json.setApplication(EntityReference)",
      "void ImmutableApplicationCost.Json.setCost(Cost)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableApplicationCost.Json actualJson = new ImmutableApplicationCost.Json();
    actualJson.setApplication(null);
    actualJson.setCost(new Json());

    // Assert
    Cost cost = actualJson.cost;
    assertTrue(cost instanceof Json);
    assertNull(((Json) cost).costKind);
    assertNull(((Json) cost).amount);
    assertNull(((Json) cost).kind);
    assertNull(actualJson.application);
    assertEquals(0, ((Json) cost).year);
    assertFalse(((Json) cost).yearIsSet);
  }
}
