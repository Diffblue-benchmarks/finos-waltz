package org.finos.waltz.model.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableOrganisationalUnitHierarchyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#addAllChildren(Iterable)}
   */
  @Test
  void testBuilderAddAllChildren() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChildren(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#addAllParents(Iterable)}
   */
  @Test
  void testBuilderAddAllParents() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParents(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#addChildren(OrganisationalUnit)}
   */
  @Test
  void testBuilderAddChildren() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren(new ImmutableOrganisationalUnit.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#addChildren(OrganisationalUnit[])}
   */
  @Test
  void testBuilderAddChildren2() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren(new ImmutableOrganisationalUnit.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#addParents(OrganisationalUnit)}
   */
  @Test
  void testBuilderAddParents() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new ImmutableOrganisationalUnit.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#addParents(OrganisationalUnit[])}
   */
  @Test
  void testBuilderAddParents2() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new ImmutableOrganisationalUnit.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#children(Iterable)}
   */
  @Test
  void testBuilderChildren() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.children(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    when(instance.parents()).thenReturn(new ArrayList<>());
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json);

    // Act
    ImmutableOrganisationalUnitHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    assertSame(json, builderResult.build().unit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    organisationalUnitList.add(json);
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(organisationalUnitList);
    when(instance.parents()).thenReturn(new ArrayList<>());
    ImmutableOrganisationalUnit.Json json2 = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json2);

    // Act
    ImmutableOrganisationalUnitHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    ImmutableOrganisationalUnitHierarchy buildResult = builderResult.build();
    List<OrganisationalUnit> childrenResult = buildResult.children();
    assertEquals(1, childrenResult.size());
    assertSame(json, childrenResult.get(0));
    assertSame(json2, buildResult.unit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    organisationalUnitList.add(json);
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    when(instance.parents()).thenReturn(organisationalUnitList);
    ImmutableOrganisationalUnit.Json json2 = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json2);

    // Act
    ImmutableOrganisationalUnitHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    ImmutableOrganisationalUnitHierarchy buildResult = builderResult.build();
    List<OrganisationalUnit> parentsResult = buildResult.parents();
    assertEquals(1, parentsResult.size());
    assertSame(json, parentsResult.get(0));
    assertSame(json2, buildResult.unit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#parents(Iterable)}
   */
  @Test
  void testBuilderParents() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parents(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Builder#unit(OrganisationalUnit)}
   */
  @Test
  void testBuilderUnit() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnit.Json unit = new ImmutableOrganisationalUnit.Json();

    // Act
    ImmutableOrganisationalUnitHierarchy.Builder actualUnitResult = builderResult.unit(unit);

    // Assert
    assertSame(unit, builderResult.build().unit());
    assertSame(builderResult, actualUnitResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#copyOf(OrganisationalUnitHierarchy)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    when(instance.parents()).thenReturn(new ArrayList<>());
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json);

    // Act
    ImmutableOrganisationalUnitHierarchy actualCopyOfResult = ImmutableOrganisationalUnitHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    List<OrganisationalUnit> childrenResult = actualCopyOfResult.children();
    assertTrue(childrenResult.isEmpty());
    assertSame(json, actualCopyOfResult.unit());
    assertSame(childrenResult, actualCopyOfResult.parents());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#copyOf(OrganisationalUnitHierarchy)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(new ImmutableOrganisationalUnit.Json());
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(organisationalUnitList);
    when(instance.parents()).thenReturn(new ArrayList<>());
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json);

    // Act
    ImmutableOrganisationalUnitHierarchy actualCopyOfResult = ImmutableOrganisationalUnitHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    assertTrue(actualCopyOfResult.parents().isEmpty());
    assertEquals(organisationalUnitList, actualCopyOfResult.children());
    assertSame(json, actualCopyOfResult.unit());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#copyOf(OrganisationalUnitHierarchy)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(new ImmutableOrganisationalUnit.Json());
    organisationalUnitList.add(new ImmutableOrganisationalUnit.Json());
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(organisationalUnitList);
    when(instance.parents()).thenReturn(new ArrayList<>());
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json);

    // Act
    ImmutableOrganisationalUnitHierarchy actualCopyOfResult = ImmutableOrganisationalUnitHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    assertTrue(actualCopyOfResult.parents().isEmpty());
    assertEquals(organisationalUnitList, actualCopyOfResult.children());
    assertSame(json, actualCopyOfResult.unit());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#copyOf(OrganisationalUnitHierarchy)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(new ImmutableOrganisationalUnit.Json());
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    when(instance.parents()).thenReturn(organisationalUnitList);
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    when(instance.unit()).thenReturn(json);

    // Act
    ImmutableOrganisationalUnitHierarchy actualCopyOfResult = ImmutableOrganisationalUnitHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    assertTrue(actualCopyOfResult.children().isEmpty());
    assertEquals(organisationalUnitList, actualCopyOfResult.parents());
    assertSame(json, actualCopyOfResult.unit());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#fromJson(ImmutableOrganisationalUnitHierarchy.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOrganisationalUnitHierarchy.Json json = new ImmutableOrganisationalUnitHierarchy.Json();
    json.setParents(null);
    json.setChildren(null);
    ImmutableOrganisationalUnit.Json unit = new ImmutableOrganisationalUnit.Json();
    json.setUnit(unit);

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult = ImmutableOrganisationalUnitHierarchy.fromJson(json);

    // Assert
    List<OrganisationalUnit> childrenResult = actualFromJsonResult.children();
    assertTrue(childrenResult.isEmpty());
    assertSame(unit, actualFromJsonResult.unit());
    assertSame(childrenResult, actualFromJsonResult.parents());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#fromJson(ImmutableOrganisationalUnitHierarchy.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<OrganisationalUnit> children = new ArrayList<>();
    children.add(new ImmutableOrganisationalUnit.Json());

    ImmutableOrganisationalUnitHierarchy.Json json = new ImmutableOrganisationalUnitHierarchy.Json();
    json.setParents(null);
    json.setChildren(children);
    ImmutableOrganisationalUnit.Json unit = new ImmutableOrganisationalUnit.Json();
    json.setUnit(unit);

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult = ImmutableOrganisationalUnitHierarchy.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.parents().isEmpty());
    assertEquals(children, actualFromJsonResult.children());
    assertSame(unit, actualFromJsonResult.unit());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy#fromJson(ImmutableOrganisationalUnitHierarchy.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(new ImmutableOrganisationalUnit.Json());
    organisationalUnitList.add(new ImmutableOrganisationalUnit.Json());
    COWArrayList<OrganisationalUnit> parents = mock(COWArrayList.class);
    when(parents.iterator()).thenReturn(organisationalUnitList.iterator());
    COWArrayList<OrganisationalUnit> children = mock(COWArrayList.class);

    ArrayList<OrganisationalUnit> organisationalUnitList2 = new ArrayList<>();
    when(children.iterator()).thenReturn(organisationalUnitList2.iterator());

    ImmutableOrganisationalUnitHierarchy.Json json = new ImmutableOrganisationalUnitHierarchy.Json();
    json.setParents(parents);
    json.setChildren(children);
    ImmutableOrganisationalUnit.Json unit = new ImmutableOrganisationalUnit.Json();
    json.setUnit(unit);

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult = ImmutableOrganisationalUnitHierarchy.fromJson(json);

    // Assert
    verify(parents).iterator();
    verify(children).iterator();
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertEquals(organisationalUnitList, actualFromJsonResult.parents());
    assertSame(unit, actualFromJsonResult.unit());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Json#children()}
   */
  @Test
  void testJsonChildren() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOrganisationalUnitHierarchy.Json()).children());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOrganisationalUnitHierarchy.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOrganisationalUnitHierarchy.Json actualJson = new ImmutableOrganisationalUnitHierarchy.Json();

    // Assert
    assertNull(actualJson.unit);
    assertTrue(actualJson.children.isEmpty());
    assertTrue(actualJson.parents.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnitHierarchy.Json#parents()}
   */
  @Test
  void testJsonParents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOrganisationalUnitHierarchy.Json()).parents());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnitHierarchy.Json#unit()}
   */
  @Test
  void testJsonUnit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnitHierarchy.Json()).unit());
  }
}
