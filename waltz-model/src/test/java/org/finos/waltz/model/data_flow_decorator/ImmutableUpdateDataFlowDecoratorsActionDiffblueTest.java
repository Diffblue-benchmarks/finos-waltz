package org.finos.waltz.model.data_flow_decorator;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.data_flow_decorator.ImmutableUpdateDataFlowDecoratorsAction.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableUpdateDataFlowDecoratorsAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDataFlowDecoratorsActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAddedDecorators(EntityReference)} with {@code element}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAddedDecorators(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addAddedDecorators(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAddedDecorators(EntityReference)"})
  void testBuilderAddAddedDecoratorsWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDecorators(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addAddedDecorators(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAddedDecorators(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addAddedDecorators(EntityReference[]) with 'elements'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAddedDecorators(EntityReference[])"})
  void testBuilderAddAddedDecoratorsWithElements_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDecorators(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addAllAddedDecorators(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAddedDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAddedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAddedDecorators(Iterable)"})
  void testBuilderAddAllAddedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAddedDecorators(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRemovedDecorators(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRemovedDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRemovedDecorators(Iterable)"})
  void testBuilderAddAllRemovedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovedDecorators(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRemovedDecorators(EntityReference)} with {@code element}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRemovedDecorators(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addRemovedDecorators(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovedDecorators(EntityReference)"})
  void testBuilderAddRemovedDecoratorsWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDecorators(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addRemovedDecorators(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRemovedDecorators(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addRemovedDecorators(EntityReference[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovedDecorators(EntityReference[])"})
  void testBuilderAddRemovedDecoratorsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDecorators(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addedDecorators(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addedDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addedDecorators(Iterable)"})
  void testBuilderAddedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addedDecorators(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#flowId(Long)}.
   * <p>
   * Method under test: {@link Builder#flowId(Long)}
   */
  @Test
  @DisplayName("Test Builder flowId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowId(Long)"})
  void testBuilderFlowId() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertEquals(1L, builderResult.build().flowId().longValue());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataFlowDecoratorsAction)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build flowId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataFlowDecoratorsAction); given one; then builder build flowId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataFlowDecoratorsAction)"})
  void testBuilderFrom_givenOne_thenBuilderBuildFlowIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(new HashSet<>());
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1L, builderResult.build().flowId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataFlowDecoratorsAction)}.
   * <ul>
   *   <li>Then return build addedDecorators size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataFlowDecoratorsAction); then return build addedDecorators size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataFlowDecoratorsAction)"})
  void testBuilderFrom_thenReturnBuildAddedDecoratorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(entityReferenceSet);
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    ImmutableUpdateDataFlowDecoratorsAction buildResult = actualFromResult.build();
    assertEquals(1, buildResult.addedDecorators().size());
    assertEquals(1, builderResult.build().addedDecorators().size());
    assertTrue(buildResult.removedDecorators().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataFlowDecoratorsAction)}.
   * <ul>
   *   <li>Then return build removedDecorators size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataFlowDecoratorsAction); then return build removedDecorators size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDataFlowDecoratorsAction)"})
  void testBuilderFrom_thenReturnBuildRemovedDecoratorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(new HashSet<>());
    when(instance.removedDecorators()).thenReturn(entityReferenceSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1, actualFromResult.build().removedDecorators().size());
    assertEquals(1, builderResult.build().removedDecorators().size());
  }

  /**
   * Test Builder {@link Builder#removedDecorators(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#removedDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removedDecorators(Iterable)"})
  void testBuilderRemovedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removedDecorators(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#addedDecorators()}.
   * <p>
   * Method under test: {@link Json#addedDecorators()}
   */
  @Test
  @DisplayName("Test Json addedDecorators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.addedDecorators()"})
  void testJsonAddedDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).addedDecorators());
  }

  /**
   * Test Json {@link Json#flowId()}.
   * <p>
   * Method under test: {@link Json#flowId()}
   */
  @Test
  @DisplayName("Test Json flowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.flowId()"})
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowId());
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
    assertNull(actualJson.flowId);
    assertTrue(actualJson.addedDecorators.isEmpty());
    assertTrue(actualJson.removedDecorators.isEmpty());
  }

  /**
   * Test Json {@link Json#removedDecorators()}.
   * <p>
   * Method under test: {@link Json#removedDecorators()}
   */
  @Test
  @DisplayName("Test Json removedDecorators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.removedDecorators()"})
  void testJsonRemovedDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).removedDecorators());
  }
}
