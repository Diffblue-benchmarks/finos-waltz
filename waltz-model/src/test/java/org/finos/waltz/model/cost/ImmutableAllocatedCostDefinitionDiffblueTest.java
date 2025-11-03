package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.cost.ImmutableAllocatedCostDefinition.Builder;
import org.finos.waltz.model.cost.ImmutableAllocatedCostDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocatedCostDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#allocationScheme(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allocationScheme(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder allocationScheme(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocationScheme(EntityReference)"})
  void testBuilderAllocationScheme_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationScheme(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(AllocatedCostDefinition)} with {@code AllocatedCostDefinition}.
   * <p>
   * Method under test: {@link Builder#from(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(AllocatedCostDefinition) with 'AllocatedCostDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocatedCostDefinition)"})
  void testBuilderFromWithAllocatedCostDefinition() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    when(instance.allocationScheme()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allocationScheme();
    verify(instance).targetCostKind();
  }

  /**
   * Test Builder {@link Builder#from(AllocatedCostDefinition)} with {@code AllocatedCostDefinition}.
   * <p>
   * Method under test: {@link Builder#from(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(AllocatedCostDefinition) with 'AllocatedCostDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocatedCostDefinition)"})
  void testBuilderFromWithAllocatedCostDefinition2() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    when(instance.sourceCostKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
  }

  /**
   * Test Builder {@link Builder#from(AllocatedCostDefinition)} with {@code AllocatedCostDefinition}.
   * <p>
   * Method under test: {@link Builder#from(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(AllocatedCostDefinition) with 'AllocatedCostDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocatedCostDefinition)"})
  void testBuilderFromWithAllocatedCostDefinition3() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
  }

  /**
   * Test Builder {@link Builder#from(AllocatedCostDefinition)} with {@code AllocatedCostDefinition}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(AllocatedCostDefinition) with 'AllocatedCostDefinition'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocatedCostDefinition)"})
  void testBuilderFromWithAllocatedCostDefinition_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AllocatedCostDefinition)} with {@code AllocatedCostDefinition}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(AllocatedCostDefinition) with 'AllocatedCostDefinition'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocatedCostDefinition)"})
  void testBuilderFromWithAllocatedCostDefinition_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#sourceCostKind(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#sourceCostKind(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder sourceCostKind(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceCostKind(EntityReference)"})
  void testBuilderSourceCostKind_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceCostKind(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#targetCostKind(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#targetCostKind(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder targetCostKind(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetCostKind(EntityReference)"})
  void testBuilderTargetCostKind_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetCostKind(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#allocationScheme()}.
   * <p>
   * Method under test: {@link Json#allocationScheme()}
   */
  @Test
  @DisplayName("Test Json allocationScheme()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.allocationScheme()"})
  void testJsonAllocationScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationScheme());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertNull(actualJson.allocationScheme);
    assertNull(actualJson.sourceCostKind);
    assertNull(actualJson.targetCostKind);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#sourceCostKind()}.
   * <p>
   * Method under test: {@link Json#sourceCostKind()}
   */
  @Test
  @DisplayName("Test Json sourceCostKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.sourceCostKind()"})
  void testJsonSourceCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sourceCostKind());
  }

  /**
   * Test Json {@link Json#targetCostKind()}.
   * <p>
   * Method under test: {@link Json#targetCostKind()}
   */
  @Test
  @DisplayName("Test Json targetCostKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.targetCostKind()"})
  void testJsonTargetCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetCostKind());
  }
}
