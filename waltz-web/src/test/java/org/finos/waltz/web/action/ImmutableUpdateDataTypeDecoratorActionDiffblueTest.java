package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.web.action.ImmutableUpdateDataTypeDecoratorAction.Builder;
import org.finos.waltz.web.action.ImmutableUpdateDataTypeDecoratorAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDataTypeDecoratorActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAddedDataTypeIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addAddedDataTypeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addAddedDataTypeIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAddedDataTypeIds(long)"})
  void testBuilderAddAddedDataTypeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDataTypeIds(1L));
  }

  /**
   * Test Builder {@link Builder#addAddedDataTypeIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addAddedDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addAddedDataTypeIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAddedDataTypeIds(long[])"})
  void testBuilderAddAddedDataTypeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDataTypeIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#addAllAddedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAddedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAddedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAddedDataTypeIds(Iterable)"})
  void testBuilderAddAllAddedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAddedDataTypeIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllAddedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAddedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAddedDataTypeIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAddedDataTypeIds(Iterable)"})
  void testBuilderAddAllAddedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAddedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRemovedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRemovedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRemovedDataTypeIds(Iterable)"})
  void testBuilderAddAllRemovedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovedDataTypeIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllRemovedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRemovedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovedDataTypeIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRemovedDataTypeIds(Iterable)"})
  void testBuilderAddAllRemovedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRemovedDataTypeIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRemovedDataTypeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRemovedDataTypeIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovedDataTypeIds(long)"})
  void testBuilderAddRemovedDataTypeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDataTypeIds(1L));
  }

  /**
   * Test Builder {@link Builder#addRemovedDataTypeIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRemovedDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRemovedDataTypeIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovedDataTypeIds(long[])"})
  void testBuilderAddRemovedDataTypeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDataTypeIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#addedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addedDataTypeIds(Iterable)"})
  void testBuilderAddedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addedDataTypeIds(elements));
  }

  /**
   * Test Builder {@link Builder#addedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addedDataTypeIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addedDataTypeIds(Iterable)"})
  void testBuilderAddedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(entityReference));
    assertSame(entityReference, builderResult.build().entityReference());
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then return build addedDataTypeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataTypeDecoratorAction); given HashSet() add minus two; then return build addedDataTypeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenReturnBuildAddedDataTypeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    ImmutableUpdateDataTypeDecoratorAction buildResult = actualFromResult.build();
    Set<Long> addedDataTypeIdsResult = buildResult.addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult.size());
    Set<Long> addedDataTypeIdsResult2 = builderResult.build().addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult2.size());
    assertTrue(addedDataTypeIdsResult.contains(-2L));
    assertTrue(addedDataTypeIdsResult2.contains(-2L));
    assertTrue(buildResult.removedDataTypeIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataTypeDecoratorAction); given HashSet(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom_givenHashSet_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   * <ul>
   *   <li>Then return build removedDataTypeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataTypeDecoratorAction); then return build removedDataTypeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom_thenReturnBuildRemovedDataTypeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.removedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    Set<Long> removedDataTypeIdsResult = actualFromResult.build().removedDataTypeIds();
    assertEquals(1, removedDataTypeIdsResult.size());
    Set<Long> removedDataTypeIdsResult2 = builderResult.build().removedDataTypeIds();
    assertEquals(1, removedDataTypeIdsResult2.size());
    assertTrue(removedDataTypeIdsResult.contains(-2L));
    assertTrue(removedDataTypeIdsResult2.contains(-2L));
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataTypeDecoratorAction); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
  }

  /**
   * Test Builder {@link Builder#removedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#removedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removedDataTypeIds(Iterable)"})
  void testBuilderRemovedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.removedDataTypeIds(elements));
  }

  /**
   * Test Builder {@link Builder#removedDataTypeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#removedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removedDataTypeIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removedDataTypeIds(Iterable)"})
  void testBuilderRemovedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#addedDataTypeIds()}.
   * <p>
   * Method under test: {@link Json#addedDataTypeIds()}
   */
  @Test
  @DisplayName("Test Json addedDataTypeIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.addedDataTypeIds()"})
  void testJsonAddedDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).addedDataTypeIds());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
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
    assertNull(actualJson.entityReference);
    assertTrue(actualJson.addedDataTypeIds.isEmpty());
    assertTrue(actualJson.removedDataTypeIds.isEmpty());
  }

  /**
   * Test Json {@link Json#removedDataTypeIds()}.
   * <p>
   * Method under test: {@link Json#removedDataTypeIds()}
   */
  @Test
  @DisplayName("Test Json removedDataTypeIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.removedDataTypeIds()"})
  void testJsonRemovedDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).removedDataTypeIds());
  }
}
