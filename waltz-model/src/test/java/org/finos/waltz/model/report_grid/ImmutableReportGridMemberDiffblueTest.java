package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ImmutableReportGridMember.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMember.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberDiffblueTest {
  /**
   * Test {@link ImmutableReportGridMember#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridMember#builder()}
   *   <li>{@link ImmutableReportGridMember#role(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridMember Builder.build()", "Builder Builder.role(ReportGridMemberRole)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableReportGridMember.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.role(ReportGridMemberRole.VIEWER));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMember)}.
   * <ul>
   *   <li>Given {@code VIEWER}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridMember)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridMember); given 'VIEWER'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridMember)"})
  void testBuilderFrom_givenViewer_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridMember.builder();
    ReportGridMember instance = mock(ReportGridMember.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.gridId()).thenReturn(1L);
    when(instance.user()).thenReturn(mock(Person.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#gridId(Long)}.
   * <p>
   * Method under test: {@link Builder#gridId(Long)}
   */
  @Test
  @DisplayName("Test Builder gridId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.gridId(Long)"})
  void testBuilderGridId() {
    // Arrange
    Builder builderResult = ImmutableReportGridMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
  }

  /**
   * Test Builder {@link Builder#user(Person)}.
   * <ul>
   *   <li>When {@link Person}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#user(Person)}
   */
  @Test
  @DisplayName("Test Builder user(Person); when Person; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.user(Person)"})
  void testBuilderUser_whenPerson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.user(mock(Person.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGridId(Long)}
   *   <li>{@link Json#setRole(ReportGridMemberRole)}
   *   <li>{@link Json#setUser(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setGridId(Long)", "void Json.setRole(ReportGridMemberRole)",
      "void Json.setUser(Person)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGridId(1L);
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUser(null);

    // Assert
    assertEquals(1L, actualJson.gridId.longValue());
  }

  /**
   * Test Json {@link Json#gridId()}.
   * <p>
   * Method under test: {@link Json#gridId()}
   */
  @Test
  @DisplayName("Test Json gridId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.gridId()"})
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).gridId());
  }

  /**
   * Test Json {@link Json#role()}.
   * <p>
   * Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).role());
  }

  /**
   * Test Json {@link Json#user()}.
   * <p>
   * Method under test: {@link Json#user()}
   */
  @Test
  @DisplayName("Test Json user()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person Json.user()"})
  void testJsonUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).user());
  }
}
