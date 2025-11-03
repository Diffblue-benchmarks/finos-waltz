package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Builder;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRequiredInvolvementsResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRequiredInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRequiredInvolvementKindIds(Iterable)"})
  void testBuilderAddAllRequiredInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRequiredInvolvementKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRequiredInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRequiredInvolvementKindIds(Iterable)"})
  void testBuilderAddAllRequiredInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRequiredInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRequiredInvolvementKindIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRequiredInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRequiredInvolvementKindIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRequiredInvolvementKindIds(long)"})
  void testBuilderAddRequiredInvolvementKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRequiredInvolvementKindIds(1L));
  }

  /**
   * Test Builder {@link Builder#addRequiredInvolvementKindIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRequiredInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRequiredInvolvementKindIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRequiredInvolvementKindIds(long[])"})
  void testBuilderAddRequiredInvolvementKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRequiredInvolvementKindIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#areAllUsersAllowed(boolean)}.
   * <p>
   * Method under test: {@link Builder#areAllUsersAllowed(boolean)}
   */
  @Test
  @DisplayName("Test Builder areAllUsersAllowed(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.areAllUsersAllowed(boolean)"})
  void testBuilderAreAllUsersAllowed() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    Builder actualAreAllUsersAllowedResult = builderResult.areAllUsersAllowed(true);

    // Assert
    assertTrue(builderResult.build().areAllUsersAllowed());
    assertSame(builderResult, actualAreAllUsersAllowedResult);
  }

  /**
   * Test Builder {@link Builder#from(RequiredInvolvementsResult)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build areAllUsersAllowed.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName("Test Builder from(RequiredInvolvementsResult); given HashSet(); then builder build areAllUsersAllowed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RequiredInvolvementsResult)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildAreAllUsersAllowed() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    assertTrue(builderResult.build().areAllUsersAllowed());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RequiredInvolvementsResult)}.
   * <ul>
   *   <li>Then builder build requiredInvolvementKindIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName("Test Builder from(RequiredInvolvementsResult); then builder build requiredInvolvementKindIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RequiredInvolvementsResult)"})
  void testBuilderFrom_thenBuilderBuildRequiredInvolvementKindIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(12L);
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(resultLongSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    ImmutableRequiredInvolvementsResult buildResult = builderResult.build();
    Set<Long> requiredInvolvementKindIdsResult = buildResult.requiredInvolvementKindIds();
    assertEquals(1, requiredInvolvementKindIdsResult.size());
    assertTrue(requiredInvolvementKindIdsResult.contains(12L));
    assertTrue(buildResult.areAllUsersAllowed());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#requiredInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#requiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder requiredInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.requiredInvolvementKindIds(Iterable)"})
  void testBuilderRequiredInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#requiredInvolvementKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#requiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder requiredInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.requiredInvolvementKindIds(Iterable)"})
  void testBuilderRequiredInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#areAllUsersAllowed()}.
   * <p>
   * Method under test: {@link Json#areAllUsersAllowed()}
   */
  @Test
  @DisplayName("Test Json areAllUsersAllowed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.areAllUsersAllowed()"})
  void testJsonAreAllUsersAllowed() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).areAllUsersAllowed());
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
    assertFalse(actualJson.areAllUsersAllowed);
    assertFalse(actualJson.areAllUsersAllowedIsSet);
    assertTrue(actualJson.requiredInvolvementKindIds.isEmpty());
  }

  /**
   * Test Json {@link Json#requiredInvolvementKindIds()}.
   * <p>
   * Method under test: {@link Json#requiredInvolvementKindIds()}
   */
  @Test
  @DisplayName("Test Json requiredInvolvementKindIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.requiredInvolvementKindIds()"})
  void testJsonRequiredInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).requiredInvolvementKindIds());
  }

  /**
   * Test Json {@link Json#setAreAllUsersAllowed(boolean)}.
   * <p>
   * Method under test: {@link Json#setAreAllUsersAllowed(boolean)}
   */
  @Test
  @DisplayName("Test Json setAreAllUsersAllowed(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAreAllUsersAllowed(boolean)"})
  void testJsonSetAreAllUsersAllowed() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAreAllUsersAllowed(true);

    // Assert
    assertTrue(json.areAllUsersAllowed);
    assertTrue(json.areAllUsersAllowedIsSet);
  }
}
