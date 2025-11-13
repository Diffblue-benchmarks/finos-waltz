package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValues(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllValues(Iterable)"})
  void testBuilderAddAllValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllValuesResult = builderResult.addAllValues(elements);

    // Assert
    assertSame(builderResult, actualAddAllValuesResult);
  }

  /**
   * Test Builder {@link Builder#addAllValues(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValues(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllValues(Iterable)"})
  void testBuilderAddAllValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act
    Builder actualAddAllValuesResult = builderResult.addAllValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllValuesResult);
  }

  /**
   * Test Builder {@link Builder#addValues(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addValues(long)}
   */
  @Test
  @DisplayName("Test Builder addValues(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValues(long)"})
  void testBuilderAddValuesWithElement() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act
    Builder actualAddValuesResult = builderResult.addValues(1L);

    // Assert
    assertSame(builderResult, actualAddValuesResult);
  }

  /**
   * Test Builder {@link Builder#addValues(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addValues(long[])}
   */
  @Test
  @DisplayName("Test Builder addValues(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValues(long[])"})
  void testBuilderAddValuesWithElements() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act
    Builder actualAddValuesResult = builderResult.addValues(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddValuesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableIdGroup actualImmutableIdGroup = ImmutableIdGroup.builder().key(1L).build();

    // Assert
    assertEquals(1L, actualImmutableIdGroup.key().longValue());
    assertTrue(actualImmutableIdGroup.values().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(IdGroup)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addValues minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdGroup)}
   */
  @Test
  @DisplayName("Test Builder from(IdGroup); given minus two; when builder addValues minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdGroup)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddValuesMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    Builder builderResult2 = ImmutableIdGroup.builder();
    builderResult2.addValues(-2L);
    ImmutableIdGroup instance = builderResult2.key(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableIdGroup actualImmutableIdGroup = builderResult.build();
    assertEquals(instance, actualImmutableIdGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdGroup)}.
   *
   * <ul>
   *   <li>When builder key one build.
   *   <li>Then builder build is builder key one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdGroup)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdGroup); when builder key one build; then builder build is builder key one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdGroup)"})
  void testBuilderFrom_whenBuilderKeyOneBuild_thenBuilderBuildIsBuilderKeyOneBuild() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();
    ImmutableIdGroup instance = ImmutableIdGroup.builder().key(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableIdGroup actualImmutableIdGroup = builderResult.build();
    assertEquals(instance, actualImmutableIdGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(Long)}.
   *
   * <p>Method under test: {@link Builder#key(Long)}
   */
  @Test
  @DisplayName("Test Builder key(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#values(Iterable)}
   */
  @Test
  @DisplayName("Test Builder values(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.values(Iterable)"})
  void testBuilderValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualValuesResult = builderResult.values(elements);

    // Assert
    assertSame(builderResult, actualValuesResult);
  }

  /**
   * Test Builder {@link Builder#values(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#values(Iterable)}
   */
  @Test
  @DisplayName("Test Builder values(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.values(Iterable)"})
  void testBuilderValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();

    // Act
    Builder actualValuesResult = builderResult.values(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualValuesResult);
  }

  /**
   * Test {@link ImmutableIdGroup#copyOf(IdGroup)}.
   *
   * <ul>
   *   <li>When builder key one build.
   *   <li>Then return key longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#copyOf(IdGroup)}
   */
  @Test
  @DisplayName("Test copyOf(IdGroup); when builder key one build; then return key longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.copyOf(IdGroup)"})
  void testCopyOf_whenBuilderKeyOneBuild_thenReturnKeyLongValueIsOne() {
    // Arrange
    ImmutableIdGroup instance = ImmutableIdGroup.builder().key(1L).build();

    // Act
    ImmutableIdGroup actualCopyOfResult = ImmutableIdGroup.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.key().longValue());
    assertTrue(actualCopyOfResult.values().isEmpty());
  }

  /**
   * Test {@link ImmutableIdGroup#equals(Object)}, and {@link ImmutableIdGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdGroup#equals(Object)}
   *   <li>{@link ImmutableIdGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableIdGroup.equals(Object)", "int ImmutableIdGroup.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableIdGroup immutableIdGroup = ImmutableIdGroup.builder().key(1L).build();
    ImmutableIdGroup immutableIdGroup2 = ImmutableIdGroup.builder().key(1L).build();

    // Act and Assert
    assertEquals(immutableIdGroup, immutableIdGroup2);
    assertEquals(immutableIdGroup.hashCode(), immutableIdGroup2.hashCode());
  }

  /**
   * Test {@link ImmutableIdGroup#equals(Object)}, and {@link ImmutableIdGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdGroup#equals(Object)}
   *   <li>{@link ImmutableIdGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableIdGroup.equals(Object)", "int ImmutableIdGroup.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableIdGroup immutableIdGroup = ImmutableIdGroup.builder().key(1L).build();

    // Act and Assert
    assertEquals(immutableIdGroup, immutableIdGroup);
    int expectedHashCodeResult = immutableIdGroup.hashCode();
    assertEquals(expectedHashCodeResult, immutableIdGroup.hashCode());
  }

  /**
   * Test {@link ImmutableIdGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableIdGroup.equals(Object)", "int ImmutableIdGroup.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableIdGroup.builder();
    builderResult.addValues(1L);
    ImmutableIdGroup immutableIdGroup = builderResult.key(1L).build();

    // Act and Assert
    assertNotEquals(immutableIdGroup, ImmutableIdGroup.builder().key(1L).build());
  }

  /**
   * Test {@link ImmutableIdGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableIdGroup.equals(Object)", "int ImmutableIdGroup.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableIdGroup immutableIdGroup = ImmutableIdGroup.builder().key(0L).build();

    // Act and Assert
    assertNotEquals(immutableIdGroup, ImmutableIdGroup.builder().key(1L).build());
  }

  /**
   * Test {@link ImmutableIdGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableIdGroup.equals(Object)", "int ImmutableIdGroup.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableIdGroup.builder().key(1L).build(), null);
  }

  /**
   * Test {@link ImmutableIdGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableIdGroup.equals(Object)", "int ImmutableIdGroup.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableIdGroup.builder().key(1L).build(), "Different type to ImmutableIdGroup");
  }

  /**
   * Test {@link ImmutableIdGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return values is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add one; then return values is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.fromJson(Json)"})
  void testFromJson_givenArrayListAddOne_thenReturnValuesIsArrayList() {
    // Arrange
    ArrayList<Long> values = new ArrayList<>();
    values.add(1L);
    values.add(1L);

    Json json = new Json();
    json.setKey(1L);
    json.setValues(values);

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    assertEquals(values, actualFromJsonResult.values());
  }

  /**
   * Test {@link ImmutableIdGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return values size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add one; then return values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.fromJson(Json)"})
  void testFromJson_givenArrayListAddOne_thenReturnValuesSizeIsOne() {
    // Arrange
    ArrayList<Long> values = new ArrayList<>();
    values.add(1L);

    Json json = new Json();
    json.setKey(1L);
    json.setValues(values);

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    List<Long> valuesResult = actualFromJsonResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals(1L, valuesResult.get(0).longValue());
  }

  /**
   * Test {@link ImmutableIdGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return key longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return key longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnKeyLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setKey(1L);
    json.setValues(new ArrayList<>());

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.key().longValue());
    assertTrue(actualFromJsonResult.values().isEmpty());
  }

  /**
   * Test {@link ImmutableIdGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Values is {@code null}.
   *   <li>Then return key longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Values is 'null'; then return key longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonValuesIsNull_thenReturnKeyLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setKey(1L);
    json.setValues(null);

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.key().longValue());
    assertTrue(actualFromJsonResult.values().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdGroup#toString()}
   *   <li>{@link ImmutableIdGroup#values()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableIdGroup.toString()", "List ImmutableIdGroup.values()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableIdGroup immutableIdGroup = ImmutableIdGroup.builder().key(1L).build();

    // Act
    String actualToStringResult = immutableIdGroup.toString();

    // Assert
    assertEquals("IdGroup{key=1, values=[]}", actualToStringResult);
    assertTrue(immutableIdGroup.values().isEmpty());
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#values()}
   */
  @Test
  @DisplayName("Test Json values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.values()"})
  void testJsonValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().values());
  }

  /**
   * Test {@link ImmutableIdGroup#key()}.
   *
   * <p>Method under test: {@link ImmutableIdGroup#key()}
   */
  @Test
  @DisplayName("Test key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ImmutableIdGroup.key()"})
  void testKey() {
    // Arrange, Act and Assert
    assertEquals(1L, ImmutableIdGroup.builder().key(1L).build().key().longValue());
  }

  /**
   * Test {@link ImmutableIdGroup#withKey(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return key longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#withKey(Long)}
   */
  @Test
  @DisplayName("Test withKey(Long); when forty-two; then return key longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.withKey(Long)"})
  void testWithKey_whenFortyTwo_thenReturnKeyLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableIdGroup actualWithKeyResult = ImmutableIdGroup.builder().key(1L).build().withKey(42L);

    // Assert
    assertEquals(42L, actualWithKeyResult.key().longValue());
    assertTrue(actualWithKeyResult.values().isEmpty());
  }

  /**
   * Test {@link ImmutableIdGroup#withKey(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder key one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#withKey(Long)}
   */
  @Test
  @DisplayName("Test withKey(Long); when one; then return builder key one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.withKey(Long)"})
  void testWithKey_whenOne_thenReturnBuilderKeyOneBuild() {
    // Arrange
    ImmutableIdGroup immutableIdGroup = ImmutableIdGroup.builder().key(1L).build();

    // Act
    ImmutableIdGroup actualWithKeyResult = immutableIdGroup.withKey(1L);

    // Assert
    assertSame(immutableIdGroup, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableIdGroup#withValues(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return values size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdGroup#withValues(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withValues(Iterable) with 'Iterable'; given one; then return values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.withValues(Iterable)"})
  void testWithValuesWithIterable_givenOne_thenReturnValuesSizeIsOne() {
    // Arrange
    ImmutableIdGroup immutableIdGroup = ImmutableIdGroup.builder().key(1L).build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableIdGroup actualWithValuesResult = immutableIdGroup.withValues(elements);

    // Assert
    List<Long> valuesResult = actualWithValuesResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals(1L, valuesResult.get(0).longValue());
    assertEquals(1L, actualWithValuesResult.key().longValue());
  }

  /**
   * Test {@link ImmutableIdGroup#withValues(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableIdGroup#withValues(long[])}
   */
  @Test
  @DisplayName("Test withValues(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdGroup ImmutableIdGroup.withValues(long[])"})
  void testWithValuesWithLong() {
    // Arrange and Act
    ImmutableIdGroup actualWithValuesResult =
        ImmutableIdGroup.builder().key(1L).build().withValues(1L, -1L, 1L, -1L);

    // Assert
    List<Long> valuesResult = actualWithValuesResult.values();
    assertEquals(4, valuesResult.size());
    assertEquals(-1L, valuesResult.get(1).longValue());
    assertEquals(-1L, valuesResult.get(3).longValue());
    assertEquals(1L, valuesResult.get(0).longValue());
    assertEquals(1L, valuesResult.get(2).longValue());
    assertEquals(1L, actualWithValuesResult.key().longValue());
  }
}
