package org.finos.waltz.model.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.system.ImmutableSystemChangeSet.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSystemChangeSetDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDeletes(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return build inserts Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDeletes(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllDeletes(Iterable); given '42'; when ArrayList() add '42'; then return build inserts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDeletes(Iterable)"})
  void testBuilderAddAllDeletes_given42_whenArrayListAdd42_thenReturnBuildInsertsEmpty() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act and Assert
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet =
        builderResult.addAllDeletes(elements).build();
    List<Object> insertsResult = immutableSystemChangeSet.inserts();
    assertTrue(insertsResult.isEmpty());
    assertEquals(elements, immutableSystemChangeSet.deletes());
    assertEquals(elements, builderResult.build().deletes());
    assertSame(insertsResult, immutableSystemChangeSet.updates());
  }

  /**
   * Test Builder {@link Builder#addAllDeletes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDeletes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDeletes(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDeletes(Iterable)"})
  void testBuilderAddAllDeletes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddAllDeletesResult =
        builderResult.addAllDeletes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDeletesResult);
  }

  /**
   * Test Builder {@link Builder#addAllInserts(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then builder build inserts is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInserts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllInserts(Iterable); given '42'; then builder build inserts is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInserts(Iterable)"})
  void testBuilderAddAllInserts_given42_thenBuilderBuildInsertsIsArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    Builder<Object, Object> actualAddAllInsertsResult = builderResult.addAllInserts(elements);

    // Assert
    assertEquals(elements, builderResult.build().inserts());
    assertSame(builderResult, actualAddAllInsertsResult);
  }

  /**
   * Test Builder {@link Builder#addAllInserts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInserts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInserts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInserts(Iterable)"})
  void testBuilderAddAllInserts_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddAllInsertsResult =
        builderResult.addAllInserts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllInsertsResult);
  }

  /**
   * Test Builder {@link Builder#addAllUpdates(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then builder build updates is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUpdates(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllUpdates(Iterable); given '42'; then builder build updates is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUpdates(Iterable)"})
  void testBuilderAddAllUpdates_given42_thenBuilderBuildUpdatesIsArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    Builder<Object, Object> actualAddAllUpdatesResult = builderResult.addAllUpdates(elements);

    // Assert
    assertEquals(elements, builderResult.build().updates());
    assertSame(builderResult, actualAddAllUpdatesResult);
  }

  /**
   * Test Builder {@link Builder#addAllUpdates(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUpdates(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUpdates(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUpdates(Iterable)"})
  void testBuilderAddAllUpdates_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddAllUpdatesResult =
        builderResult.addAllUpdates(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllUpdatesResult);
  }

  /**
   * Test Builder {@link Builder#addDeletes(Object)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addDeletes(Object)}
   */
  @Test
  @DisplayName("Test Builder addDeletes(Object) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDeletes(Object)"})
  void testBuilderAddDeletesWithElement() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddDeletesResult = builderResult.addDeletes("Element");

    // Assert
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("Element", deletesResult.get(0));
    assertSame(builderResult, actualAddDeletesResult);
  }

  /**
   * Test Builder {@link Builder#addDeletes(Object[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addDeletes(Object[])}
   */
  @Test
  @DisplayName("Test Builder addDeletes(Object[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDeletes(Object[])"})
  void testBuilderAddDeletesWithElements() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddDeletesResult = builderResult.addDeletes("Elements");

    // Assert
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("Elements", deletesResult.get(0));
    assertSame(builderResult, actualAddDeletesResult);
  }

  /**
   * Test Builder {@link Builder#addInserts(Object)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addInserts(Object)}
   */
  @Test
  @DisplayName("Test Builder addInserts(Object) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInserts(Object)"})
  void testBuilderAddInsertsWithElement() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddInsertsResult = builderResult.addInserts("Element");

    // Assert
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("Element", insertsResult.get(0));
    assertSame(builderResult, actualAddInsertsResult);
  }

  /**
   * Test Builder {@link Builder#addInserts(Object[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addInserts(Object[])}
   */
  @Test
  @DisplayName("Test Builder addInserts(Object[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInserts(Object[])"})
  void testBuilderAddInsertsWithElements() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddInsertsResult = builderResult.addInserts("Elements");

    // Assert
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("Elements", insertsResult.get(0));
    assertSame(builderResult, actualAddInsertsResult);
  }

  /**
   * Test Builder {@link Builder#addUpdates(Object)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addUpdates(Object)}
   */
  @Test
  @DisplayName("Test Builder addUpdates(Object) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUpdates(Object)"})
  void testBuilderAddUpdatesWithElement() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddUpdatesResult = builderResult.addUpdates("Element");

    // Assert
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("Element", updatesResult.get(0));
    assertSame(builderResult, actualAddUpdatesResult);
  }

  /**
   * Test Builder {@link Builder#addUpdates(Object[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addUpdates(Object[])}
   */
  @Test
  @DisplayName("Test Builder addUpdates(Object[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUpdates(Object[])"})
  void testBuilderAddUpdatesWithElements() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualAddUpdatesResult = builderResult.addUpdates("Elements");

    // Assert
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("Elements", updatesResult.get(0));
    assertSame(builderResult, actualAddUpdatesResult);
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
  @MethodsUnderTest({"ImmutableSystemChangeSet Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object, Object> actualBuilderResult = ImmutableSystemChangeSet.builder();

    // Assert
    assertTrue(actualBuilderResult.build().deletes().isEmpty());
  }

  /**
   * Test Builder {@link Builder#deletes(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return build inserts Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#deletes(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder deletes(Iterable); given '42'; when ArrayList() add '42'; then return build inserts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.deletes(Iterable)"})
  void testBuilderDeletes_given42_whenArrayListAdd42_thenReturnBuildInsertsEmpty() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act and Assert
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet =
        builderResult.deletes(elements).build();
    List<Object> insertsResult = immutableSystemChangeSet.inserts();
    assertTrue(insertsResult.isEmpty());
    assertEquals(elements, immutableSystemChangeSet.deletes());
    assertEquals(elements, builderResult.build().deletes());
    assertSame(insertsResult, immutableSystemChangeSet.updates());
  }

  /**
   * Test Builder {@link Builder#deletes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#deletes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder deletes(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.deletes(Iterable)"})
  void testBuilderDeletes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualDeletesResult = builderResult.deletes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDeletesResult);
  }

  /**
   * Test Builder {@link Builder#from(SystemChangeSet)}.
   *
   * <ul>
   *   <li>Given {@code Element}.
   *   <li>Then return build updates size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SystemChangeSet)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SystemChangeSet); given 'Element'; then return build updates size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SystemChangeSet)"})
  void testBuilderFrom_givenElement_thenReturnBuildUpdatesSizeIsOne() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();
    builderResult2.addUpdates("Element");

    // Act and Assert
    List<Object> updatesResult = builderResult.from(builderResult2.build()).build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("Element", updatesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(SystemChangeSet)}.
   *
   * <ul>
   *   <li>When builder addDeletes {@code Element}.
   *   <li>Then return build deletes size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SystemChangeSet)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SystemChangeSet); when builder addDeletes 'Element'; then return build deletes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SystemChangeSet)"})
  void testBuilderFrom_whenBuilderAddDeletesElement_thenReturnBuildDeletesSizeIsOne() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();
    builderResult2.addDeletes("Element");
    builderResult2.addUpdates("Element");

    // Act and Assert
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet =
        builderResult.from(builderResult2.build()).build();
    List<Object> deletesResult = immutableSystemChangeSet.deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("Element", deletesResult.get(0));
    assertTrue(immutableSystemChangeSet.inserts().isEmpty());
    assertEquals(deletesResult, immutableSystemChangeSet.updates());
  }

  /**
   * Test Builder {@link Builder#from(SystemChangeSet)}.
   *
   * <ul>
   *   <li>When builder addInserts {@code Element}.
   *   <li>Then return build inserts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SystemChangeSet)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SystemChangeSet); when builder addInserts 'Element'; then return build inserts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SystemChangeSet)"})
  void testBuilderFrom_whenBuilderAddInsertsElement_thenReturnBuildInsertsSizeIsOne() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();
    builderResult2.addInserts("Element");
    builderResult2.addUpdates("Element");

    // Act and Assert
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet =
        builderResult.from(builderResult2.build()).build();
    List<Object> insertsResult = immutableSystemChangeSet.inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("Element", insertsResult.get(0));
    assertEquals(insertsResult, immutableSystemChangeSet.updates());
  }

  /**
   * Test Builder {@link Builder#from(SystemChangeSet)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SystemChangeSet)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SystemChangeSet); when builder build; then return build deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SystemChangeSet)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildDeletesEmpty() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();

    // Act and Assert
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet =
        builderResult.from(builderResult2.build()).build();
    List<Object> deletesResult = immutableSystemChangeSet.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, immutableSystemChangeSet.inserts());
    assertSame(deletesResult, immutableSystemChangeSet.updates());
  }

  /**
   * Test Builder {@link Builder#inserts(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then builder build inserts is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inserts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder inserts(Iterable); given '42'; when ArrayList() add '42'; then builder build inserts is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inserts(Iterable)"})
  void testBuilderInserts_given42_whenArrayListAdd42_thenBuilderBuildInsertsIsArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    Builder<Object, Object> actualInsertsResult = builderResult.inserts(elements);

    // Assert
    assertEquals(elements, builderResult.build().inserts());
    assertSame(builderResult, actualInsertsResult);
  }

  /**
   * Test Builder {@link Builder#inserts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inserts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inserts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inserts(Iterable)"})
  void testBuilderInserts_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualInsertsResult = builderResult.inserts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInsertsResult);
  }

  /**
   * Test Builder {@link Builder#updates(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then builder build updates is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#updates(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder updates(Iterable); given '42'; when ArrayList() add '42'; then builder build updates is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.updates(Iterable)"})
  void testBuilderUpdates_given42_whenArrayListAdd42_thenBuilderBuildUpdatesIsArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    Builder<Object, Object> actualUpdatesResult = builderResult.updates(elements);

    // Assert
    assertEquals(elements, builderResult.build().updates());
    assertSame(builderResult, actualUpdatesResult);
  }

  /**
   * Test Builder {@link Builder#updates(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#updates(Iterable)}
   */
  @Test
  @DisplayName("Test Builder updates(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.updates(Iterable)"})
  void testBuilderUpdates_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    Builder<Object, Object> actualUpdatesResult = builderResult.updates(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualUpdatesResult);
  }

  /**
   * Test {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}
   */
  @Test
  @DisplayName("Test copyOf(SystemChangeSet); when builder build; then return deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemChangeSet ImmutableSystemChangeSet.copyOf(SystemChangeSet)"})
  void testCopyOf_whenBuilderBuild_thenReturnDeletesEmpty() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    ImmutableSystemChangeSet<Object, Object> instance = builderResult.build();

    // Act
    ImmutableSystemChangeSet<Object, Object> actualCopyOfResult =
        ImmutableSystemChangeSet.copyOf(instance);

    // Assert
    List<Object> deletesResult = actualCopyOfResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualCopyOfResult.inserts());
    assertSame(deletesResult, actualCopyOfResult.updates());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}, and {@link
   * ImmutableSystemChangeSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSystemChangeSet#equals(Object)}
   *   <li>{@link ImmutableSystemChangeSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet = builderResult.build();

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet2 = builderResult2.build();

    // Act and Assert
    assertEquals(immutableSystemChangeSet, immutableSystemChangeSet2);
    assertEquals(immutableSystemChangeSet.hashCode(), immutableSystemChangeSet2.hashCode());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}, and {@link
   * ImmutableSystemChangeSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSystemChangeSet#equals(Object)}
   *   <li>{@link ImmutableSystemChangeSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet = builderResult.build();

    // Act and Assert
    assertEquals(immutableSystemChangeSet, immutableSystemChangeSet);
    int expectedHashCodeResult = immutableSystemChangeSet.hashCode();
    assertEquals(expectedHashCodeResult, immutableSystemChangeSet.hashCode());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    builderResult.addUpdates("Element");

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertNotEquals(builderResult.build(), builderResult2.build());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    builderResult.addDeletes("Element");

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertNotEquals(builderResult.build(), builderResult2.build());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    builderResult.addInserts("Element");

    Builder<Object, Object> builderResult2 = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertNotEquals(builderResult.build(), builderResult2.build());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertNotEquals(builderResult.build(), null);
  }

  /**
   * Test {@link ImmutableSystemChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemChangeSet.equals(Object)",
    "int ImmutableSystemChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertNotEquals(builderResult.build(), "Different type to ImmutableSystemChangeSet");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSystemChangeSet#toString()}
   *   <li>{@link ImmutableSystemChangeSet#deletes()}
   *   <li>{@link ImmutableSystemChangeSet#inserts()}
   *   <li>{@link ImmutableSystemChangeSet#updates()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSystemChangeSet.deletes()",
    "List ImmutableSystemChangeSet.inserts()",
    "String ImmutableSystemChangeSet.toString()",
    "List ImmutableSystemChangeSet.updates()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    ImmutableSystemChangeSet<Object, Object> immutableSystemChangeSet = builderResult.build();

    // Act
    String actualToStringResult = immutableSystemChangeSet.toString();
    List<Object> actualDeletesResult = immutableSystemChangeSet.deletes();
    List<Object> actualInsertsResult = immutableSystemChangeSet.inserts();
    List<Object> actualUpdatesResult = immutableSystemChangeSet.updates();

    // Assert
    assertEquals("SystemChangeSet{updates=[], deletes=[], inserts=[]}", actualToStringResult);
    assertTrue(actualDeletesResult.isEmpty());
    assertSame(actualDeletesResult, actualInsertsResult);
    assertSame(actualDeletesResult, actualUpdatesResult);
  }

  /**
   * Test {@link ImmutableSystemChangeSet#withDeletes(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Elements}.
   *   <li>Then return deletes size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#withDeletes(Object[])}
   */
  @Test
  @DisplayName(
      "Test withDeletes(Object[]) with 'Object[]'; when 'Elements'; then return deletes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemChangeSet ImmutableSystemChangeSet.withDeletes(Object[])"})
  void testWithDeletesWithObject_whenElements_thenReturnDeletesSizeIsOne() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet<Object, Object> actualWithDeletesResult =
        builderResult.build().withDeletes("Elements");

    // Assert
    List<Object> deletesResult = actualWithDeletesResult.deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("Elements", deletesResult.get(0));
    List<Object> insertsResult = actualWithDeletesResult.inserts();
    assertTrue(insertsResult.isEmpty());
    assertSame(insertsResult, actualWithDeletesResult.updates());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#withInserts(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Elements}.
   *   <li>Then return inserts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#withInserts(Object[])}
   */
  @Test
  @DisplayName(
      "Test withInserts(Object[]) with 'Object[]'; when 'Elements'; then return inserts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemChangeSet ImmutableSystemChangeSet.withInserts(Object[])"})
  void testWithInsertsWithObject_whenElements_thenReturnInsertsSizeIsOne() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet<Object, Object> actualWithInsertsResult =
        builderResult.build().withInserts("Elements");

    // Assert
    List<Object> insertsResult = actualWithInsertsResult.inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("Elements", insertsResult.get(0));
    List<Object> deletesResult = actualWithInsertsResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualWithInsertsResult.updates());
  }

  /**
   * Test {@link ImmutableSystemChangeSet#withUpdates(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Elements}.
   *   <li>Then return updates size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemChangeSet#withUpdates(Object[])}
   */
  @Test
  @DisplayName(
      "Test withUpdates(Object[]) with 'Object[]'; when 'Elements'; then return updates size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemChangeSet ImmutableSystemChangeSet.withUpdates(Object[])"})
  void testWithUpdatesWithObject_whenElements_thenReturnUpdatesSizeIsOne() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet<Object, Object> actualWithUpdatesResult =
        builderResult.build().withUpdates("Elements");

    // Assert
    List<Object> updatesResult = actualWithUpdatesResult.updates();
    assertEquals(1, updatesResult.size());
    assertEquals("Elements", updatesResult.get(0));
    List<Object> deletesResult = actualWithUpdatesResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualWithUpdatesResult.inserts());
  }
}
