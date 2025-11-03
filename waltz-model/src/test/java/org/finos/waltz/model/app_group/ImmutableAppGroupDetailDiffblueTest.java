package org.finos.waltz.model.app_group;

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
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiatives(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangeInitiatives(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiatives(Iterable)"})
  void testBuilderAddAllChangeInitiatives_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiatives(new ArrayList<>()));
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
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMembers(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllOrganisationalUnits(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOrganisationalUnits(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOrganisationalUnits(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOrganisationalUnits(Iterable)"})
  void testBuilderAddAllOrganisationalUnits_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOrganisationalUnits(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplications(AppGroupEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplications(AppGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder addApplications(AppGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplications(AppGroupEntry)"})
  void testBuilderAddApplicationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new Json()));
  }

  /**
   * Test Builder {@link Builder#addApplications(AppGroupEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplications(AppGroupEntry[])}
   */
  @Test
  @DisplayName("Test Builder addApplications(AppGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplications(AppGroupEntry[])"})
  void testBuilderAddApplicationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new Json()));
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(AppGroupEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChangeInitiatives(AppGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiatives(AppGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(AppGroupEntry)"})
  void testBuilderAddChangeInitiativesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangeInitiatives(new Json()));
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(AppGroupEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChangeInitiatives(AppGroupEntry[])}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiatives(AppGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(AppGroupEntry[])"})
  void testBuilderAddChangeInitiativesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangeInitiatives(new Json()));
  }

  /**
   * Test Builder {@link Builder#addMembers(AppGroupMember)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAppGroupMember.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMembers(AppGroupMember)}
   */
  @Test
  @DisplayName("Test Builder addMembers(AppGroupMember) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMembers(AppGroupMember)"})
  void testBuilderAddMembersWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableAppGroupMember.Json()));
  }

  /**
   * Test Builder {@link Builder#addMembers(AppGroupMember[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAppGroupMember.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMembers(AppGroupMember[])}
   */
  @Test
  @DisplayName("Test Builder addMembers(AppGroupMember[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMembers(AppGroupMember[])"})
  void testBuilderAddMembersWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableAppGroupMember.Json()));
  }

  /**
   * Test Builder {@link Builder#addOrganisationalUnits(AppGroupEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOrganisationalUnits(AppGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder addOrganisationalUnits(AppGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOrganisationalUnits(AppGroupEntry)"})
  void testBuilderAddOrganisationalUnitsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOrganisationalUnits(new Json()));
  }

  /**
   * Test Builder {@link Builder#addOrganisationalUnits(AppGroupEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOrganisationalUnits(AppGroupEntry[])}
   */
  @Test
  @DisplayName("Test Builder addOrganisationalUnits(AppGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOrganisationalUnits(AppGroupEntry[])"})
  void testBuilderAddOrganisationalUnitsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOrganisationalUnits(new Json()));
  }

  /**
   * Test Builder {@link Builder#appGroup(AppGroup)}.
   * <ul>
   *   <li>When {@link ImmutableAppGroup.Json} (default constructor).</li>
   *   <li>Then builder build appGroup is {@link ImmutableAppGroup.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#appGroup(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder appGroup(AppGroup); when Json (default constructor); then builder build appGroup is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appGroup(AppGroup)"})
  void testBuilderAppGroup_whenJson_thenBuilderBuildAppGroupIsJson() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroup.Json appGroup = new ImmutableAppGroup.Json();

    // Act
    Builder actualAppGroupResult = builderResult.appGroup(appGroup);

    // Assert
    assertSame(appGroup, builderResult.build().appGroup());
    assertSame(builderResult, actualAppGroupResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#changeInitiatives(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiatives(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeInitiatives(Iterable)"})
  void testBuilderChangeInitiatives_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiatives(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   *   <li>Then builder build applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail); given ArrayList() add Json (default constructor); then builder build applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    Json json = new Json();
    appGroupEntryList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(appGroupEntryList);
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> applicationsResult = builderResult.build().applications();
    assertEquals(1, applicationsResult.size());
    ImmutableAppGroupDetail buildResult = actualFromResult.build();
    List<AppGroupEntry> changeInitiativesResult = buildResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, buildResult.applications());
    assertSame(json, applicationsResult.get(0));
    assertSame(changeInitiativesResult, buildResult.members());
    assertSame(changeInitiativesResult, buildResult.organisationalUnits());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   *   <li>Then builder build changeInitiatives size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail); given ArrayList() add Json (default constructor); then builder build changeInitiatives size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildChangeInitiativesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    Json json = new Json();
    appGroupEntryList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(appGroupEntryList);
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> changeInitiativesResult = builderResult.build().changeInitiatives();
    assertEquals(1, changeInitiativesResult.size());
    assertEquals(appGroupEntryList, actualFromResult.build().changeInitiatives());
    assertSame(json, changeInitiativesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAppGroupMember.Json} (default constructor).</li>
   *   <li>Then builder build members size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail); given ArrayList() add Json (default constructor); then builder build members size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildMembersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupMember> appGroupMemberList = new ArrayList<>();
    ImmutableAppGroupMember.Json json = new ImmutableAppGroupMember.Json();
    appGroupMemberList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(appGroupMemberList);
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupMember> membersResult = builderResult.build().members();
    assertEquals(1, membersResult.size());
    assertEquals(appGroupMemberList, actualFromResult.build().members());
    assertSame(json, membersResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail); given ArrayList(); then return build applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    ImmutableAppGroupDetail buildResult = actualFromResult.build();
    List<AppGroupEntry> applicationsResult = buildResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, buildResult.changeInitiatives());
    assertSame(applicationsResult, buildResult.members());
    assertSame(applicationsResult, buildResult.organisationalUnits());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   * <ul>
   *   <li>Then builder build organisationalUnits size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail); then builder build organisationalUnits size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom_thenBuilderBuildOrganisationalUnitsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    Json json = new Json();
    appGroupEntryList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(appGroupEntryList);
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> organisationalUnitsResult = builderResult.build().organisationalUnits();
    assertEquals(1, organisationalUnitsResult.size());
    assertEquals(appGroupEntryList, actualFromResult.build().organisationalUnits());
    assertSame(json, organisationalUnitsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.members()).thenThrow(new IllegalStateException("instance"));
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appGroup();
    verify(instance).members();
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
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.members(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#organisationalUnits(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#organisationalUnits(Iterable)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnits(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.organisationalUnits(Iterable)"})
  void testBuilderOrganisationalUnits_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnits(new ArrayList<>()));
  }

  /**
   * Test Json {@link ImmutableAppGroupDetail.Json#appGroup()}.
   * <p>
   * Method under test: {@link ImmutableAppGroupDetail.Json#appGroup()}
   */
  @Test
  @DisplayName("Test Json appGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppGroup ImmutableAppGroupDetail.Json.appGroup()"})
  void testJsonAppGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).appGroup());
  }

  /**
   * Test Json {@link ImmutableAppGroupDetail.Json#applications()}.
   * <p>
   * Method under test: {@link ImmutableAppGroupDetail.Json#applications()}
   */
  @Test
  @DisplayName("Test Json applications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableAppGroupDetail.Json.applications()"})
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).applications());
  }

  /**
   * Test Json {@link ImmutableAppGroupDetail.Json#changeInitiatives()}.
   * <p>
   * Method under test: {@link ImmutableAppGroupDetail.Json#changeInitiatives()}
   */
  @Test
  @DisplayName("Test Json changeInitiatives()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableAppGroupDetail.Json.changeInitiatives()"})
  void testJsonChangeInitiatives() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).changeInitiatives());
  }

  /**
   * Test Json {@link ImmutableAppGroupDetail.Json#members()}.
   * <p>
   * Method under test: {@link ImmutableAppGroupDetail.Json#members()}
   */
  @Test
  @DisplayName("Test Json members()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableAppGroupDetail.Json.members()"})
  void testJsonMembers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).members());
  }

  /**
   * Test Json new {@link ImmutableAppGroupDetail.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableAppGroupDetail.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableAppGroupDetail.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppGroupDetail.Json actualJson = new ImmutableAppGroupDetail.Json();

    // Assert
    assertNull(actualJson.appGroup);
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.changeInitiatives.isEmpty());
    assertTrue(actualJson.members.isEmpty());
    assertTrue(actualJson.organisationalUnits.isEmpty());
  }

  /**
   * Test Json {@link ImmutableAppGroupDetail.Json#organisationalUnits()}.
   * <p>
   * Method under test: {@link ImmutableAppGroupDetail.Json#organisationalUnits()}
   */
  @Test
  @DisplayName("Test Json organisationalUnits()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableAppGroupDetail.Json.organisationalUnits()"})
  void testJsonOrganisationalUnits() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).organisationalUnits());
  }
}
