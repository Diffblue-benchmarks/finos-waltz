package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupDetailDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addAllApplications(Iterable)}
   */
  @Test
  void testBuilderAddAllApplications() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  void testBuilderAddAllChangeInitiatives() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiatives(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addAllMembers(Iterable)}
   */
  @Test
  void testBuilderAddAllMembers() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMembers(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addAllOrganisationalUnits(Iterable)}
   */
  @Test
  void testBuilderAddAllOrganisationalUnits() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOrganisationalUnits(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addApplications(AppGroupEntry)}
   */
  @Test
  void testBuilderAddApplications() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new ImmutableAppGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addApplications(AppGroupEntry[])}
   */
  @Test
  void testBuilderAddApplications2() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new ImmutableAppGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addChangeInitiatives(AppGroupEntry)}
   */
  @Test
  void testBuilderAddChangeInitiatives() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangeInitiatives(new ImmutableAppGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addChangeInitiatives(AppGroupEntry[])}
   */
  @Test
  void testBuilderAddChangeInitiatives2() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangeInitiatives(new ImmutableAppGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addMembers(AppGroupMember)}
   */
  @Test
  void testBuilderAddMembers() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableAppGroupMember.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addMembers(AppGroupMember[])}
   */
  @Test
  void testBuilderAddMembers2() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableAppGroupMember.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addOrganisationalUnits(AppGroupEntry)}
   */
  @Test
  void testBuilderAddOrganisationalUnits() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOrganisationalUnits(new ImmutableAppGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#addOrganisationalUnits(AppGroupEntry[])}
   */
  @Test
  void testBuilderAddOrganisationalUnits2() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOrganisationalUnits(new ImmutableAppGroupEntry.Json()));
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail.Builder#appGroup(AppGroup)}
   */
  @Test
  void testBuilderAppGroup() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroup.Json appGroup = new ImmutableAppGroup.Json();

    // Act
    ImmutableAppGroupDetail.Builder actualAppGroupResult = builderResult.appGroup(appGroup);

    // Assert
    assertSame(appGroup, builderResult.build().appGroup());
    assertSame(builderResult, actualAppGroupResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#applications(Iterable)}
   */
  @Test
  void testBuilderApplications() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#changeInitiatives(Iterable)}
   */
  @Test
  void testBuilderChangeInitiatives() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiatives(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#from(AppGroupDetail)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    assertSame(json, builderResult.build().appGroup());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#from(AppGroupDetail)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.members()).thenThrow(new IllegalStateException("instance"));
    when(instance.appGroup()).thenReturn(new ImmutableAppGroup.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appGroup();
    verify(instance).members();
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#from(AppGroupDetail)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    ImmutableAppGroupEntry.Json json = new ImmutableAppGroupEntry.Json();
    appGroupEntryList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(appGroupEntryList);
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json2 = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json2);

    // Act
    ImmutableAppGroupDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    ImmutableAppGroupDetail buildResult = builderResult.build();
    List<AppGroupEntry> applicationsResult = buildResult.applications();
    assertEquals(1, applicationsResult.size());
    assertSame(json2, buildResult.appGroup());
    assertSame(json, applicationsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#from(AppGroupDetail)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    ImmutableAppGroupEntry.Json json = new ImmutableAppGroupEntry.Json();
    appGroupEntryList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(appGroupEntryList);
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json2 = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json2);

    // Act
    ImmutableAppGroupDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    ImmutableAppGroupDetail buildResult = builderResult.build();
    List<AppGroupEntry> changeInitiativesResult = buildResult.changeInitiatives();
    assertEquals(1, changeInitiativesResult.size());
    assertSame(json2, buildResult.appGroup());
    assertSame(json, changeInitiativesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#from(AppGroupDetail)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupMember> appGroupMemberList = new ArrayList<>();
    ImmutableAppGroupMember.Json json = new ImmutableAppGroupMember.Json();
    appGroupMemberList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(appGroupMemberList);
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json2 = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json2);

    // Act
    ImmutableAppGroupDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    ImmutableAppGroupDetail buildResult = builderResult.build();
    List<AppGroupMember> membersResult = buildResult.members();
    assertEquals(1, membersResult.size());
    assertSame(json2, buildResult.appGroup());
    assertSame(json, membersResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#from(AppGroupDetail)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    ImmutableAppGroupEntry.Json json = new ImmutableAppGroupEntry.Json();
    appGroupEntryList.add(json);
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(appGroupEntryList);
    ImmutableAppGroup.Json json2 = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json2);

    // Act
    ImmutableAppGroupDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    ImmutableAppGroupDetail buildResult = builderResult.build();
    List<AppGroupEntry> organisationalUnitsResult = buildResult.organisationalUnits();
    assertEquals(1, organisationalUnitsResult.size());
    assertSame(json2, buildResult.appGroup());
    assertSame(json, organisationalUnitsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail.Builder#members(Iterable)}
   */
  @Test
  void testBuilderMembers() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.members(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail.Builder#organisationalUnits(Iterable)}
   */
  @Test
  void testBuilderOrganisationalUnits() {
    // Arrange
    ImmutableAppGroupDetail.Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnits(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.appGroup());
    assertSame(applicationsResult, actualCopyOfResult.changeInitiatives());
    assertSame(applicationsResult, actualCopyOfResult.members());
    assertSame(applicationsResult, actualCopyOfResult.organisationalUnits());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(new ImmutableAppGroupEntry.Json());
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(appGroupEntryList);
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> changeInitiativesResult = actualCopyOfResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, actualCopyOfResult.applications());
    assertSame(json, actualCopyOfResult.appGroup());
    assertSame(changeInitiativesResult, actualCopyOfResult.members());
    assertSame(changeInitiativesResult, actualCopyOfResult.organisationalUnits());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(new ImmutableAppGroupEntry.Json());
    appGroupEntryList.add(new ImmutableAppGroupEntry.Json());
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(appGroupEntryList);
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> changeInitiativesResult = actualCopyOfResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, actualCopyOfResult.applications());
    assertSame(json, actualCopyOfResult.appGroup());
    assertSame(changeInitiativesResult, actualCopyOfResult.members());
    assertSame(changeInitiativesResult, actualCopyOfResult.organisationalUnits());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(new ImmutableAppGroupEntry.Json());
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(appGroupEntryList);
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(appGroupEntryList, actualCopyOfResult.changeInitiatives());
    assertSame(json, actualCopyOfResult.appGroup());
    assertSame(applicationsResult, actualCopyOfResult.members());
    assertSame(applicationsResult, actualCopyOfResult.organisationalUnits());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<AppGroupMember> appGroupMemberList = new ArrayList<>();
    appGroupMemberList.add(new ImmutableAppGroupMember.Json());
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(appGroupMemberList);
    when(instance.organisationalUnits()).thenReturn(new ArrayList<>());
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(appGroupMemberList, actualCopyOfResult.members());
    assertSame(json, actualCopyOfResult.appGroup());
    assertSame(applicationsResult, actualCopyOfResult.changeInitiatives());
    assertSame(applicationsResult, actualCopyOfResult.organisationalUnits());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(new ImmutableAppGroupEntry.Json());
    AppGroupDetail instance = mock(AppGroupDetail.class);
    when(instance.applications()).thenReturn(new ArrayList<>());
    when(instance.changeInitiatives()).thenReturn(new ArrayList<>());
    when(instance.members()).thenReturn(new ArrayList<>());
    when(instance.organisationalUnits()).thenReturn(appGroupEntryList);
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    when(instance.appGroup()).thenReturn(json);

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).applications();
    verify(instance).changeInitiatives();
    verify(instance).members();
    verify(instance).organisationalUnits();
    List<AppGroupEntry> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(appGroupEntryList, actualCopyOfResult.organisationalUnits());
    assertSame(json, actualCopyOfResult.appGroup());
    assertSame(applicationsResult, actualCopyOfResult.changeInitiatives());
    assertSame(applicationsResult, actualCopyOfResult.members());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail#fromJson(ImmutableAppGroupDetail.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppGroupDetail.Json json = new ImmutableAppGroupDetail.Json();
    ImmutableAppGroup.Json appGroup = new ImmutableAppGroup.Json();
    json.setAppGroup(appGroup);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json);

    // Assert
    List<AppGroupEntry> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(appGroup, actualFromJsonResult.appGroup());
    List<AppGroupEntry> appGroupEntryList = json.organisationalUnits;
    assertSame(appGroupEntryList, applicationsResult);
    assertSame(appGroupEntryList, actualFromJsonResult.changeInitiatives());
    assertSame(appGroupEntryList, actualFromJsonResult.members());
    assertSame(appGroupEntryList, actualFromJsonResult.organisationalUnits());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail#fromJson(ImmutableAppGroupDetail.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<AppGroupEntry> changeInitiatives = new ArrayList<>();
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());

    ImmutableAppGroupDetail.Json json = new ImmutableAppGroupDetail.Json();
    ImmutableAppGroup.Json appGroup = new ImmutableAppGroup.Json();
    json.setAppGroup(appGroup);
    json.setMembers(null);
    json.setApplications(null);
    json.setOrganisationalUnits(null);
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json);

    // Assert
    List<AppGroupEntry> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
    assertSame(appGroup, actualFromJsonResult.appGroup());
    assertSame(applicationsResult, actualFromJsonResult.members());
    assertSame(applicationsResult, actualFromJsonResult.organisationalUnits());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupDetail#fromJson(ImmutableAppGroupDetail.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<AppGroupEntry> changeInitiatives = new ArrayList<>();
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());

    ImmutableAppGroupDetail.Json json = new ImmutableAppGroupDetail.Json();
    ImmutableAppGroup.Json appGroup = new ImmutableAppGroup.Json();
    json.setAppGroup(appGroup);
    json.setMembers(null);
    json.setApplications(null);
    json.setOrganisationalUnits(null);
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json);

    // Assert
    List<AppGroupEntry> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
    assertSame(appGroup, actualFromJsonResult.appGroup());
    assertSame(applicationsResult, actualFromJsonResult.members());
    assertSame(applicationsResult, actualFromJsonResult.organisationalUnits());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail.Json#appGroup()}
   */
  @Test
  void testJsonAppGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).appGroup());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail.Json#applications()}
   */
  @Test
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).applications());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail.Json#changeInitiatives()}
   */
  @Test
  void testJsonChangeInitiatives() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).changeInitiatives());
  }

  /**
   * Method under test: {@link ImmutableAppGroupDetail.Json#members()}
   */
  @Test
  void testJsonMembers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).members());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppGroupDetail.Json}
   */
  @Test
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
   * Method under test: {@link ImmutableAppGroupDetail.Json#organisationalUnits()}
   */
  @Test
  void testJsonOrganisationalUnits() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupDetail.Json()).organisationalUnits());
  }
}
