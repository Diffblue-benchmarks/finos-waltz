package org.finos.waltz.model.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand.Builder;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecificationDeleteCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(PhysicalSpecificationDeleteCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build specificationId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecificationDeleteCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecificationDeleteCommand); given one; then builder build specificationId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecificationDeleteCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildSpecificationIdIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationDeleteCommand.builder();
    PhysicalSpecificationDeleteCommand instance = mock(PhysicalSpecificationDeleteCommand.class);
    when(instance.specificationId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).specificationId();
    assertEquals(1L, builderResult.build().specificationId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#specificationId(long)}.
   * <p>
   * Method under test: {@link Builder#specificationId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specificationId(long)"})
  void testBuilderSpecificationId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationDeleteCommand.builder();

    // Act
    Builder actualSpecificationIdResult = builderResult.specificationId(1L);

    // Assert
    assertEquals(1L, builderResult.build().specificationId());
    assertSame(builderResult, actualSpecificationIdResult);
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#setSpecificationId(long)}.
   * <p>
   * Method under test: {@link Json#setSpecificationId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSpecificationId(long)"})
  void testJsonSetSpecificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#specificationId()}.
   * <p>
   * Method under test: {@link Json#specificationId()}
   */
  @Test
  @DisplayName("Test Json specificationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.specificationId()"})
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specificationId());
  }
}
