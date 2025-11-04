package org.finos.waltz.model.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableSystemChangeSetDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addAllDeletes(Iterable)}
   */
  @Test
  void testBuilderAddAllDeletes() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDeletes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addAllDeletes(Iterable)}
   */
  @Test
  void testBuilderAddAllDeletes2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddAllDeletesResult = builderResult.addAllDeletes(elements);

    // Assert
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("42", deletesResult.get(0));
    assertSame(builderResult, actualAddAllDeletesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addAllInserts(Iterable)}
   */
  @Test
  void testBuilderAddAllInserts() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInserts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addAllInserts(Iterable)}
   */
  @Test
  void testBuilderAddAllInserts2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddAllInsertsResult = builderResult.addAllInserts(elements);

    // Assert
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("42", insertsResult.get(0));
    assertSame(builderResult, actualAddAllInsertsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addAllUpdates(Iterable)}
   */
  @Test
  void testBuilderAddAllUpdates() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUpdates(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addAllUpdates(Iterable)}
   */
  @Test
  void testBuilderAddAllUpdates2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddAllUpdatesResult = builderResult.addAllUpdates(elements);

    // Assert
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("42", updatesResult.get(0));
    assertSame(builderResult, actualAddAllUpdatesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addDeletes(Object)}
   */
  @Test
  void testBuilderAddDeletes() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddDeletesResult = builderResult.addDeletes("Element");

    // Assert
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("Element", deletesResult.get(0));
    assertSame(builderResult, actualAddDeletesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addDeletes(Object[])}
   */
  @Test
  void testBuilderAddDeletes2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddDeletesResult = builderResult.addDeletes("Elements");

    // Assert
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("Elements", deletesResult.get(0));
    assertSame(builderResult, actualAddDeletesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addInserts(Object)}
   */
  @Test
  void testBuilderAddInserts() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddInsertsResult = builderResult.addInserts("Element");

    // Assert
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("Element", insertsResult.get(0));
    assertSame(builderResult, actualAddInsertsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addInserts(Object[])}
   */
  @Test
  void testBuilderAddInserts2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddInsertsResult = builderResult.addInserts("Elements");

    // Assert
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("Elements", insertsResult.get(0));
    assertSame(builderResult, actualAddInsertsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addUpdates(Object)}
   */
  @Test
  void testBuilderAddUpdates() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddUpdatesResult = builderResult.addUpdates("Element");

    // Assert
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("Element", updatesResult.get(0));
    assertSame(builderResult, actualAddUpdatesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#addUpdates(Object[])}
   */
  @Test
  void testBuilderAddUpdates2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualAddUpdatesResult = builderResult.addUpdates("Elements");

    // Assert
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("Elements", updatesResult.get(0));
    assertSame(builderResult, actualAddUpdatesResult);
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertTrue(builderResult.build().deletes().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#deletes(Iterable)}
   */
  @Test
  void testBuilderDeletes() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.deletes(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#deletes(Iterable)}
   */
  @Test
  void testBuilderDeletes2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualDeletesResult = builderResult.deletes(elements);

    // Assert
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("42", deletesResult.get(0));
    assertSame(builderResult, actualDeletesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#from(SystemChangeSet)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(new ArrayList<>());
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#from(SystemChangeSet)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(objectList);
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> deletesResult = builderResult.build().deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("42", deletesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#from(SystemChangeSet)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(new ArrayList<>());
    when(instance.inserts()).thenReturn(objectList);
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("42", insertsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemChangeSet.Builder#from(SystemChangeSet)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(new ArrayList<>());
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(objectList);

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("42", updatesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#inserts(Iterable)}
   */
  @Test
  void testBuilderInserts() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inserts(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#inserts(Iterable)}
   */
  @Test
  void testBuilderInserts2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualInsertsResult = builderResult.inserts(elements);

    // Assert
    List<Object> insertsResult = builderResult.build().inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("42", insertsResult.get(0));
    assertSame(builderResult, actualInsertsResult);
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#updates(Iterable)}
   */
  @Test
  void testBuilderUpdates() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.updates(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet.Builder#updates(Iterable)}
   */
  @Test
  void testBuilderUpdates2() {
    // Arrange
    ImmutableSystemChangeSet.Builder<Object, Object> builderResult = ImmutableSystemChangeSet.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    ImmutableSystemChangeSet.Builder<Object, Object> actualUpdatesResult = builderResult.updates(elements);

    // Assert
    List<Object> updatesResult = builderResult.build().updates();
    assertEquals(1, updatesResult.size());
    assertEquals("42", updatesResult.get(0));
    assertSame(builderResult, actualUpdatesResult);
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(new ArrayList<>());
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet<Object, Object> actualCopyOfResult = ImmutableSystemChangeSet.copyOf(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> deletesResult = actualCopyOfResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualCopyOfResult.inserts());
    assertSame(deletesResult, actualCopyOfResult.updates());
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(objectList);
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet<Object, Object> actualCopyOfResult = ImmutableSystemChangeSet.copyOf(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> deletesResult = actualCopyOfResult.deletes();
    assertEquals(1, deletesResult.size());
    assertEquals("42", deletesResult.get(0));
    List<Object> insertsResult = actualCopyOfResult.inserts();
    assertTrue(insertsResult.isEmpty());
    assertSame(insertsResult, actualCopyOfResult.updates());
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(objectList);
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet<Object, Object> actualCopyOfResult = ImmutableSystemChangeSet.copyOf(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> insertsResult = actualCopyOfResult.inserts();
    assertTrue(insertsResult.isEmpty());
    assertEquals(objectList, actualCopyOfResult.deletes());
    assertSame(insertsResult, actualCopyOfResult.updates());
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(new ArrayList<>());
    when(instance.inserts()).thenReturn(objectList);
    when(instance.updates()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSystemChangeSet<Object, Object> actualCopyOfResult = ImmutableSystemChangeSet.copyOf(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> insertsResult = actualCopyOfResult.inserts();
    assertEquals(1, insertsResult.size());
    assertEquals("42", insertsResult.get(0));
    List<Object> deletesResult = actualCopyOfResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualCopyOfResult.updates());
  }

  /**
   * Method under test: {@link ImmutableSystemChangeSet#copyOf(SystemChangeSet)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    SystemChangeSet<Object, Object> instance = mock(SystemChangeSet.class);
    when(instance.deletes()).thenReturn(new ArrayList<>());
    when(instance.inserts()).thenReturn(new ArrayList<>());
    when(instance.updates()).thenReturn(objectList);

    // Act
    ImmutableSystemChangeSet<Object, Object> actualCopyOfResult = ImmutableSystemChangeSet.copyOf(instance);

    // Assert
    verify(instance).deletes();
    verify(instance).inserts();
    verify(instance).updates();
    List<Object> updatesResult = actualCopyOfResult.updates();
    assertEquals(1, updatesResult.size());
    assertEquals("42", updatesResult.get(0));
    List<Object> deletesResult = actualCopyOfResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualCopyOfResult.inserts());
  }
}
