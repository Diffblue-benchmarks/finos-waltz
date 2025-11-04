package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridMember#builder()}
   *   <li>{@link ImmutableReportGridMember#role(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridMember.Builder actualBuilderResult = ImmutableReportGridMember.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.role(ReportGridMemberRole.VIEWER));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMember.Builder#from(ReportGridMember)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridMember.Builder builderResult = ImmutableReportGridMember.builder();
    ReportGridMember instance = mock(ReportGridMember.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.gridId()).thenReturn(1L);
    when(instance.user()).thenReturn(mock(Person.class));

    // Act
    ImmutableReportGridMember.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).role();
    verify(instance).user();
    ImmutableReportGridMember buildResult = builderResult.build();
    assertEquals(1L, buildResult.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridMember.Builder#gridId(Long)}
   */
  @Test
  void testBuilderGridId() {
    // Arrange
    ImmutableReportGridMember.Builder builderResult = ImmutableReportGridMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
  }

  /**
   * Method under test: {@link ImmutableReportGridMember.Builder#user(Person)}
   */
  @Test
  void testBuilderUser() {
    // Arrange
    ImmutableReportGridMember.Builder builderResult = ImmutableReportGridMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.user(mock(Person.class)));
  }

  /**
   * Method under test: {@link ImmutableReportGridMember#copyOf(ReportGridMember)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridMember instance = mock(ReportGridMember.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.gridId()).thenReturn(1L);
    when(instance.user()).thenReturn(mock(Person.class));

    // Act
    ImmutableReportGridMember actualCopyOfResult = ImmutableReportGridMember.copyOf(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).role();
    verify(instance).user();
    assertEquals(1L, actualCopyOfResult.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMember#fromJson(ImmutableReportGridMember.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridMember.Json json = new ImmutableReportGridMember.Json();
    json.setGridId(1L);
    json.setUser(mock(Person.class));
    json.setRole(null);

    // Act
    ImmutableReportGridMember actualFromJsonResult = ImmutableReportGridMember.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
    Person expectedUserResult = json.user;
    assertSame(expectedUserResult, actualFromJsonResult.user());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMember#fromJson(ImmutableReportGridMember.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridMember.Json json = new ImmutableReportGridMember.Json();
    json.setGridId(1L);
    json.setUser(mock(Person.class));
    json.setRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGridMember actualFromJsonResult = ImmutableReportGridMember.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
    Person expectedUserResult = json.user;
    assertSame(expectedUserResult, actualFromJsonResult.user());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridMember.Json}
   *   <li>{@link ImmutableReportGridMember.Json#setGridId(Long)}
   *   <li>{@link ImmutableReportGridMember.Json#setRole(ReportGridMemberRole)}
   *   <li>{@link ImmutableReportGridMember.Json#setUser(Person)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridMember.Json actualJson = new ImmutableReportGridMember.Json();
    actualJson.setGridId(1L);
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUser(null);

    // Assert
    assertEquals(1L, actualJson.gridId.longValue());
  }

  /**
   * Method under test: {@link ImmutableReportGridMember.Json#gridId()}
   */
  @Test
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridMember.Json()).gridId());
  }

  /**
   * Method under test: {@link ImmutableReportGridMember.Json#role()}
   */
  @Test
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridMember.Json()).role());
  }

  /**
   * Method under test: {@link ImmutableReportGridMember.Json#user()}
   */
  @Test
  void testJsonUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridMember.Json()).user());
  }
}
