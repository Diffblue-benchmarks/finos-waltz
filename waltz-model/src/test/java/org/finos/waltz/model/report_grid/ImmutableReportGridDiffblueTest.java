package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGrid#builder()}
   *   <li>{@link ImmutableReportGrid#userRole(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGrid.Builder actualBuilderResult = ImmutableReportGrid.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.userRole(ReportGridMemberRole.VIEWER));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#addAllMembers(Iterable)}
   */
  @Test
  void testBuilderAddAllMembers() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMembers(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#addMembers(ReportGridMember)}
   */
  @Test
  void testBuilderAddMembers() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableReportGridMember.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#addMembers(ReportGridMember)}
   */
  @Test
  void testBuilderAddMembers2() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    ImmutableReportGridMember.Json element = new ImmutableReportGridMember.Json();
    element.setUser(mock(Person.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(element));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#addMembers(ReportGridMember[])}
   */
  @Test
  void testBuilderAddMembers3() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(new ImmutableReportGridMember.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#addMembers(ReportGridMember[])}
   */
  @Test
  void testBuilderAddMembers4() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    ImmutableReportGridMember.Json json = new ImmutableReportGridMember.Json();
    json.setUser(mock(Person.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addMembers(json));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#definition(ReportGridDefinition)}
   */
  @Test
  void testBuilderDefinition() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definition(new ImmutableReportGridDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#definition(ReportGridDefinition)}
   */
  @Test
  void testBuilderDefinition2() {
    // Arrange
    ImmutableReportGridMember.Json element = new ImmutableReportGridMember.Json();
    element.setUser(mock(Person.class));
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();
    builderResult.addMembers(element);

    // Act and Assert
    assertSame(builderResult, builderResult.definition(new ImmutableReportGridDefinition.Json()));
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Builder#from(ReportGrid)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(new HashSet<>());
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    when(instance.instance()).thenReturn(json);
    ImmutableReportGridDefinition.Json json2 = new ImmutableReportGridDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableReportGrid.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    ImmutableReportGrid buildResult = builderResult.build();
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.userRole());
    assertSame(json2, buildResult.definition());
    assertSame(json, buildResult.instance());
    assertSame(builderResult, actualFromResult);
    Set<ReportSubject> expectedMembersResult = json.subjects;
    assertSame(expectedMembersResult, buildResult.members());
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Builder#from(ReportGrid)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();
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
   * Method under test: {@link ImmutableReportGrid.Builder#from(ReportGrid)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    reportGridMemberSet.add(new ImmutableReportGridMember.Json());
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(reportGridMemberSet);
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    when(instance.instance()).thenReturn(json);
    ImmutableReportGridDefinition.Json json2 = new ImmutableReportGridDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableReportGrid.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    ImmutableReportGrid buildResult = builderResult.build();
    assertEquals(1, buildResult.members().size());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.userRole());
    assertSame(json2, buildResult.definition());
    assertSame(json, buildResult.instance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#instance(ReportGridInstance)}
   */
  @Test
  void testBuilderInstance() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instance(new ImmutableReportGridInstance.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid.Builder#instance(ReportGridInstance)}
   */
  @Test
  void testBuilderInstance2() {
    // Arrange
    ImmutableReportGridMember.Json element = new ImmutableReportGridMember.Json();
    element.setUser(mock(Person.class));
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();
    builderResult.addMembers(element);

    // Act and Assert
    assertSame(builderResult, builderResult.instance(new ImmutableReportGridInstance.Json()));
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Builder#members(Iterable)}
   */
  @Test
  void testBuilderMembers() {
    // Arrange
    ImmutableReportGrid.Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.members(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableReportGrid#copyOf(ReportGrid)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(new HashSet<>());
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    when(instance.instance()).thenReturn(json);
    ImmutableReportGridDefinition.Json json2 = new ImmutableReportGridDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableReportGrid actualCopyOfResult = ImmutableReportGrid.copyOf(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.userRole());
    Set<ReportGridMember> membersResult = actualCopyOfResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(json2, actualCopyOfResult.definition());
    assertSame(json, actualCopyOfResult.instance());
    assertSame(json.subjects, membersResult);
  }

  /**
   * Method under test: {@link ImmutableReportGrid#copyOf(ReportGrid)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    reportGridMemberSet.add(new ImmutableReportGridMember.Json());
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(reportGridMemberSet);
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    when(instance.instance()).thenReturn(json);
    ImmutableReportGridDefinition.Json json2 = new ImmutableReportGridDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableReportGrid actualCopyOfResult = ImmutableReportGrid.copyOf(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    assertEquals(1, actualCopyOfResult.members().size());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.userRole());
    assertSame(json2, actualCopyOfResult.definition());
    assertSame(json, actualCopyOfResult.instance());
  }

  /**
   * Method under test: {@link ImmutableReportGrid#copyOf(ReportGrid)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    reportGridMemberSet.add(new ImmutableReportGridMember.Json());
    reportGridMemberSet.add(new ImmutableReportGridMember.Json());
    ReportGrid instance = mock(ReportGrid.class);
    when(instance.members()).thenReturn(reportGridMemberSet);
    when(instance.userRole()).thenReturn(ReportGridMemberRole.VIEWER);
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    when(instance.instance()).thenReturn(json);
    ImmutableReportGridDefinition.Json json2 = new ImmutableReportGridDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableReportGrid actualCopyOfResult = ImmutableReportGrid.copyOf(instance);

    // Assert
    verify(instance).definition();
    verify(instance).instance();
    verify(instance).members();
    verify(instance).userRole();
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.userRole());
    assertEquals(reportGridMemberSet, actualCopyOfResult.members());
    assertSame(json2, actualCopyOfResult.definition());
    assertSame(json, actualCopyOfResult.instance());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid#fromJson(ImmutableReportGrid.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGrid.Json json = new ImmutableReportGrid.Json();
    ImmutableReportGridDefinition.Json definition = new ImmutableReportGridDefinition.Json();
    json.setDefinition(definition);
    ImmutableReportGridInstance.Json instance = new ImmutableReportGridInstance.Json();
    json.setInstance(instance);
    json.setMembers(null);
    json.setUserRole(null);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.userRole());
    Set<ReportGridMember> membersResult = actualFromJsonResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(definition, actualFromJsonResult.definition());
    assertSame(instance, actualFromJsonResult.instance());
    assertSame(instance.subjects, membersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid#fromJson(ImmutableReportGrid.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGrid.Json json = new ImmutableReportGrid.Json();
    ImmutableReportGridDefinition.Json definition = new ImmutableReportGridDefinition.Json();
    json.setDefinition(definition);
    ImmutableReportGridInstance.Json instance = new ImmutableReportGridInstance.Json();
    json.setInstance(instance);
    json.setMembers(null);
    json.setUserRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.userRole());
    Set<ReportGridMember> membersResult = actualFromJsonResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(definition, actualFromJsonResult.definition());
    assertSame(instance, actualFromJsonResult.instance());
    assertSame(instance.subjects, membersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid#fromJson(ImmutableReportGrid.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<ReportGridMember> members = new LinkedHashSet<>();
    members.add(new ImmutableReportGridMember.Json());

    ImmutableReportGrid.Json json = new ImmutableReportGrid.Json();
    ImmutableReportGridDefinition.Json definition = new ImmutableReportGridDefinition.Json();
    json.setDefinition(definition);
    ImmutableReportGridInstance.Json instance = new ImmutableReportGridInstance.Json();
    json.setInstance(instance);
    json.setMembers(members);
    json.setUserRole(null);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.members().size());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.userRole());
    assertSame(definition, actualFromJsonResult.definition());
    assertSame(instance, actualFromJsonResult.instance());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGrid#fromJson(ImmutableReportGrid.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<ReportGridMember> members = new LinkedHashSet<>();
    members.add(new ImmutableReportGridMember.Json());
    members.add(new ImmutableReportGridMember.Json());

    ImmutableReportGrid.Json json = new ImmutableReportGrid.Json();
    ImmutableReportGridDefinition.Json definition = new ImmutableReportGridDefinition.Json();
    json.setDefinition(definition);
    ImmutableReportGridInstance.Json instance = new ImmutableReportGridInstance.Json();
    json.setInstance(instance);
    json.setMembers(members);
    json.setUserRole(null);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.userRole());
    assertEquals(members, actualFromJsonResult.members());
    assertSame(definition, actualFromJsonResult.definition());
    assertSame(instance, actualFromJsonResult.instance());
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Json#definition()}
   */
  @Test
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGrid.Json()).definition());
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Json#instance()}
   */
  @Test
  void testJsonInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGrid.Json()).instance());
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Json#members()}
   */
  @Test
  void testJsonMembers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGrid.Json()).members());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGrid.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGrid.Json actualJson = new ImmutableReportGrid.Json();

    // Assert
    assertNull(actualJson.definition);
    assertNull(actualJson.instance);
    assertNull(actualJson.userRole);
    assertTrue(actualJson.members.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableReportGrid.Json#userRole()}
   */
  @Test
  void testJsonUserRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGrid.Json()).userRole());
  }
}
