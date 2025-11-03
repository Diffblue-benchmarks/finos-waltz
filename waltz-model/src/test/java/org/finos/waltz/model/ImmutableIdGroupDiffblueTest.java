package org.finos.waltz.model;

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
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.ImmutableIdGroup.Builder;
import org.finos.waltz.model.ImmutableIdGroup.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableIdGroupDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllValues(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValues(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllValues(Iterable)"})
  void testBuilderAddAllValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValues(elements));
  }

  /**
   * Test Builder {@link Builder#addAllValues(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValues(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllValues(Iterable)"})
  void testBuilderAddAllValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addValues(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addValues(long)}
   */
  @Test
  @DisplayName("Test Builder addValues(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValues(long)"})
  void testBuilderAddValuesWithElement() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(1L));
  }

  /**
   * Test Builder {@link Builder#addValues(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addValues(long[])}
   */
  @Test
  @DisplayName("Test Builder addValues(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValues(long[])"})
  void testBuilderAddValuesWithElements() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#from(IdGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.</li>
   *   <li>Then builder build values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdGroup)}
   */
  @Test
  @DisplayName("Test Builder from(IdGroup); given ArrayList() add minus two; then builder build values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdGroup)"})
  void testBuilderFrom_givenArrayListAddMinusTwo_thenBuilderBuildValuesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-2L);
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(resultLongList);
    when(instance.key()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    ImmutableIdGroup buildResult = builderResult.build();
    List<Long> valuesResult = buildResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals(-2L, valuesResult.get(0).longValue());
    assertEquals(1L, buildResult.key().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build key longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdGroup)}
   */
  @Test
  @DisplayName("Test Builder from(IdGroup); given ArrayList(); then builder build key longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdGroup)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildKeyLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(new ArrayList<>());
    when(instance.key()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertEquals(1L, builderResult.build().key().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdGroup)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdGroup)}
   */
  @Test
  @DisplayName("Test Builder from(IdGroup); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdGroup)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).values();
  }

  /**
   * Test Builder {@link Builder#key(Long)}.
   * <p>
   * Method under test: {@link Builder#key(Long)}
   */
  @Test
  @DisplayName("Test Builder key(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(Long)"})
  void testBuilderKey() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act
    Builder actualKeyResult = builderResult.key(1L);

    // Assert
    assertEquals(1L, builderResult.build().key().longValue());
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test Builder {@link Builder#values(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#values(Iterable)}
   */
  @Test
  @DisplayName("Test Builder values(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.values(Iterable)"})
  void testBuilderValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.values(elements));
  }

  /**
   * Test Builder {@link Builder#values(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#values(Iterable)}
   */
  @Test
  @DisplayName("Test Builder values(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.values(Iterable)"})
  void testBuilderValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.values(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).key());
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
    assertNull(actualJson.key);
    assertTrue(actualJson.values.isEmpty());
  }

  /**
   * Test Json {@link Json#values()}.
   * <p>
   * Method under test: {@link Json#values()}
   */
  @Test
  @DisplayName("Test Json values()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.values()"})
  void testJsonValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).values());
  }
}
