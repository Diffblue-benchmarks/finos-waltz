package org.finos.waltz.model.orgunit;

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
import java.util.List;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit.Json;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnitHierarchy.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOrganisationalUnitHierarchyDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChildren(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChildren(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChildren(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChildren(Iterable)"})
  void testBuilderAddAllChildren_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChildren(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllParents(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllParents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParents(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllParents(Iterable)"})
  void testBuilderAddAllParents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParents(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addChildren(OrganisationalUnit)} with {@code element}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChildren(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test Builder addChildren(OrganisationalUnit) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChildren(OrganisationalUnit)"})
  void testBuilderAddChildrenWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren(new Json()));
  }

  /**
   * Test Builder {@link Builder#addChildren(OrganisationalUnit[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChildren(OrganisationalUnit[])}
   */
  @Test
  @DisplayName("Test Builder addChildren(OrganisationalUnit[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChildren(OrganisationalUnit[])"})
  void testBuilderAddChildrenWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren(new Json()));
  }

  /**
   * Test Builder {@link Builder#addParents(OrganisationalUnit)} with {@code element}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParents(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test Builder addParents(OrganisationalUnit) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParents(OrganisationalUnit)"})
  void testBuilderAddParentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new Json()));
  }

  /**
   * Test Builder {@link Builder#addParents(OrganisationalUnit[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParents(OrganisationalUnit[])}
   */
  @Test
  @DisplayName("Test Builder addParents(OrganisationalUnit[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParents(OrganisationalUnit[])"})
  void testBuilderAddParentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new Json()));
  }

  /**
   * Test Builder {@link Builder#children(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#children(Iterable)}
   */
  @Test
  @DisplayName("Test Builder children(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.children(Iterable)"})
  void testBuilderChildren_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.children(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitHierarchy)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   *   <li>Then builder build children size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitHierarchy); given ArrayList() add Json (default constructor); then builder build children size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitHierarchy)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildChildrenSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    Json json = new Json();
    organisationalUnitList.add(json);
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(organisationalUnitList);
    when(instance.parents()).thenReturn(new ArrayList<>());
    when(instance.unit()).thenReturn(new Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    List<OrganisationalUnit> childrenResult = builderResult.build().children();
    assertEquals(1, childrenResult.size());
    ImmutableOrganisationalUnitHierarchy buildResult = actualFromResult.build();
    assertTrue(buildResult.parents().isEmpty());
    assertEquals(organisationalUnitList, buildResult.children());
    assertSame(json, childrenResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitHierarchy)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   *   <li>Then builder build parents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitHierarchy); given ArrayList() add Json (default constructor); then builder build parents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitHierarchy)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildParentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    Json json = new Json();
    organisationalUnitList.add(json);
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    when(instance.parents()).thenReturn(organisationalUnitList);
    when(instance.unit()).thenReturn(new Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    List<OrganisationalUnit> parentsResult = builderResult.build().parents();
    assertEquals(1, parentsResult.size());
    assertEquals(organisationalUnitList, actualFromResult.build().parents());
    assertSame(json, parentsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitHierarchy)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>Then builder build unit is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitHierarchy); given Json (default constructor); then builder build unit is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitHierarchy)"})
  void testBuilderFrom_givenJson_thenBuilderBuildUnitIsJson() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    OrganisationalUnitHierarchy instance = mock(OrganisationalUnitHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    when(instance.parents()).thenReturn(new ArrayList<>());
    Json json = new Json();
    when(instance.unit()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parents();
    verify(instance).unit();
    assertSame(json, builderResult.build().unit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#parents(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parents(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parents(Iterable)"})
  void testBuilderParents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parents(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#unit(OrganisationalUnit)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then builder build unit is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#unit(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test Builder unit(OrganisationalUnit); when Json (default constructor); then builder build unit is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.unit(OrganisationalUnit)"})
  void testBuilderUnit_whenJson_thenBuilderBuildUnitIsJson() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    Json unit = new Json();

    // Act
    Builder actualUnitResult = builderResult.unit(unit);

    // Assert
    assertSame(unit, builderResult.build().unit());
    assertSame(builderResult, actualUnitResult);
  }

  /**
   * Test Json {@link ImmutableOrganisationalUnitHierarchy.Json#children()}.
   * <p>
   * Method under test: {@link ImmutableOrganisationalUnitHierarchy.Json#children()}
   */
  @Test
  @DisplayName("Test Json children()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableOrganisationalUnitHierarchy.Json.children()"})
  void testJsonChildren() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOrganisationalUnitHierarchy.Json()).children());
  }

  /**
   * Test Json new {@link ImmutableOrganisationalUnitHierarchy.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableOrganisationalUnitHierarchy.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableOrganisationalUnitHierarchy.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOrganisationalUnitHierarchy.Json actualJson = new ImmutableOrganisationalUnitHierarchy.Json();

    // Assert
    assertNull(actualJson.unit);
    assertTrue(actualJson.children.isEmpty());
    assertTrue(actualJson.parents.isEmpty());
  }

  /**
   * Test Json {@link ImmutableOrganisationalUnitHierarchy.Json#parents()}.
   * <p>
   * Method under test: {@link ImmutableOrganisationalUnitHierarchy.Json#parents()}
   */
  @Test
  @DisplayName("Test Json parents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableOrganisationalUnitHierarchy.Json.parents()"})
  void testJsonParents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOrganisationalUnitHierarchy.Json()).parents());
  }

  /**
   * Test Json {@link ImmutableOrganisationalUnitHierarchy.Json#unit()}.
   * <p>
   * Method under test: {@link ImmutableOrganisationalUnitHierarchy.Json#unit()}
   */
  @Test
  @DisplayName("Test Json unit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OrganisationalUnit ImmutableOrganisationalUnitHierarchy.Json.unit()"})
  void testJsonUnit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnitHierarchy.Json()).unit());
  }
}
