package org.finos.waltz.model.report_grid;

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
import java.util.Set;
import org.finos.waltz.model.report_grid.ImmutableReportGrid.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGrid.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDiffblueTest {
  /**
   * Test {@link ImmutableReportGrid#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGrid#builder()}
   *   <li>{@link ImmutableReportGrid#userRole(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGrid Builder.build()", "Builder Builder.userRole(ReportGridMemberRole)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableReportGrid.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.userRole(ReportGridMemberRole.VIEWER));
  }

  /**
   * Test Builder {@link Builder#addAllMembers(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllMembers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMembers(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllMembers(Iterable)"})
  void testBuilderAddAllMembers_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMembers(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addMembers(ReportGridMember)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableReportGridMember.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMembers(ReportGridMember)}
   */
  @Test
  @DisplayName("Test Builder addMembers(ReportGridMember) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMembers(ReportGridMember)"})
  void testBuilderAddMembersWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableReportGridMember.Json()));
  }

  /**
   * Test Builder {@link Builder#addMembers(ReportGridMember[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableReportGridMember.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMembers(ReportGridMember[])}
   */
  @Test
  @DisplayName("Test Builder addMembers(ReportGridMember[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMembers(ReportGridMember[])"})
  void testBuilderAddMembersWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableReportGridMember.Json()));
  }

  /**
   * Test Builder {@link Builder#definition(ReportGridDefinition)}.
   * <ul>
   *   <li>When {@link ImmutableReportGridDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#definition(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder definition(ReportGridDefinition); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definition(ReportGridDefinition)"})
  void testBuilderDefinition_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definition(new ImmutableReportGridDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#from(ReportGrid)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableReportGridMember.Json} (default constructor).</li>
   *   <li>Then return build members size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGrid)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGrid); given HashSet() add Json (default constructor); then return build members size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGrid)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildMembersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    reportGridMemberSet.add(new ImmutableReportGridMember.Json());
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(reportGridMemberSet);
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.instance()).thenReturn(new ImmutableReportGridInstance.Json());
    when(instance.definition()).thenReturn(new ImmutableReportGridDefinition.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    ImmutableReportGrid buildResult = actualFromResult.build();
    ReportGridInstance instanceResult = buildResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    assertEquals(1, buildResult.members().size());
    assertEquals(1, builderResult.build().members().size());
    Set<ReportGridCell> reportGridCellSet = ((ImmutableReportGridInstance.Json) instanceResult).cellData;
    assertTrue(reportGridCellSet.isEmpty());
    assertSame(reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
  }

  /**
   * Test Builder {@link Builder#from(ReportGrid)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build members Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGrid)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGrid); given HashSet(); then return build members Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGrid)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildMembersEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(new HashSet<>());
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    when(instance.instance()).thenReturn(json);
    when(instance.definition()).thenReturn(new ImmutableReportGridDefinition.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    ImmutableReportGrid buildResult = actualFromResult.build();
    ReportGridInstance instanceResult = buildResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    Set<ReportGridMember> membersResult = buildResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(membersResult, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(membersResult, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
    Set<ReportSubject> reportSubjectSet = json.subjects;
    assertSame(reportSubjectSet, builderResult.build().members());
    assertSame(reportSubjectSet, ((ImmutableReportGridInstance.Json) instanceResult).cellData);
  }

  /**
   * Test Builder {@link Builder#from(ReportGrid)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGrid)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGrid); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGrid)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenThrow(new IllegalStateException("instance"));
    when(instance.instance()).thenReturn(new ImmutableReportGridInstance.Json());
    when(instance.definition()).thenReturn(new ImmutableReportGridDefinition.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
  }

  /**
   * Test Builder {@link Builder#instance(ReportGridInstance)}.
   * <ul>
   *   <li>When {@link ImmutableReportGridInstance.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#instance(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test Builder instance(ReportGridInstance); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.instance(ReportGridInstance)"})
  void testBuilderInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instance(new ImmutableReportGridInstance.Json()));
  }

  /**
   * Test Builder {@link Builder#members(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#members(Iterable)}
   */
  @Test
  @DisplayName("Test Builder members(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.members(Iterable)"})
  void testBuilderMembers_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.members(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#definition()}.
   * <p>
   * Method under test: {@link Json#definition()}
   */
  @Test
  @DisplayName("Test Json definition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridDefinition Json.definition()"})
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).definition());
  }

  /**
   * Test Json {@link Json#instance()}.
   * <p>
   * Method under test: {@link Json#instance()}
   */
  @Test
  @DisplayName("Test Json instance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridInstance Json.instance()"})
  void testJsonInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).instance());
  }

  /**
   * Test Json {@link Json#members()}.
   * <p>
   * Method under test: {@link Json#members()}
   */
  @Test
  @DisplayName("Test Json members()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.members()"})
  void testJsonMembers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).members());
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
    assertNull(actualJson.definition);
    assertNull(actualJson.instance);
    assertNull(actualJson.userRole);
    assertTrue(actualJson.members.isEmpty());
  }

  /**
   * Test Json {@link Json#userRole()}.
   * <p>
   * Method under test: {@link Json#userRole()}
   */
  @Test
  @DisplayName("Test Json userRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridMemberRole Json.userRole()"})
  void testJsonUserRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userRole());
  }
}
