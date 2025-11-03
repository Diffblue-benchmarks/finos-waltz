package org.finos.waltz.model.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroupCreateCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementGroupCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long)"})
  void testBuilderAddInvolvementKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long[])"})
  void testBuilderAddInvolvementKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroupCreateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementGroupCreateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroupCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementGroup()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroupCreateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementGroupCreateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroupCreateCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroupCreateCommand)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build involvementKindIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementGroupCreateCommand); given HashSet(); then return build involvementKindIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroupCreateCommand)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildInvolvementKindIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    assertTrue(actualFromResult.build().involvementKindIds().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroupCreateCommand)}.
   * <ul>
   *   <li>Then return build involvementKindIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementGroupCreateCommand); then return build involvementKindIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroupCreateCommand)"})
  void testBuilderFrom_thenReturnBuildInvolvementKindIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    Set<Long> involvementKindIdsResult = actualFromResult.build().involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    Set<Long> involvementKindIdsResult2 = builderResult.build().involvementKindIds();
    assertEquals(1, involvementKindIdsResult2.size());
    assertTrue(involvementKindIdsResult.contains(-2L));
    assertTrue(involvementKindIdsResult2.contains(-2L));
  }

  /**
   * Test Builder {@link Builder#involvementGroup(InvolvementGroup)}.
   * <ul>
   *   <li>When {@link InvolvementGroup}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementGroup(InvolvementGroup)}
   */
  @Test
  @DisplayName("Test Builder involvementGroup(InvolvementGroup); when InvolvementGroup; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementGroup(InvolvementGroup)"})
  void testBuilderInvolvementGroup_whenInvolvementGroup_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroup involvementGroup = mock(InvolvementGroup.class);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementGroup(involvementGroup));
    assertSame(involvementGroup, builderResult.build().involvementGroup());
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }
}
