package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkUserOperationRowPreviewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Builder#build()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Builder#givenComment(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Builder#givenRole(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Builder#givenUser(String)}
   *   <li>
   * {@link ImmutableBulkUserOperationRowPreview.Builder#resolvedComment(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Builder#resolvedRole(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Builder#resolvedUser(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualBuildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Assert
    assertEquals("Given Comment", actualBuildResult.givenComment());
    assertEquals("Given Role", actualBuildResult.givenRole());
    assertEquals("Given User", actualBuildResult.givenUser());
    assertEquals("Resolved Comment", actualBuildResult.resolvedComment());
    assertEquals("Resolved Role", actualBuildResult.resolvedRole());
    assertEquals("Resolved User", actualBuildResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, actualBuildResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Comment", buildResult.givenComment());
    assertEquals("Given Role", buildResult.givenRole());
    assertEquals("Given User", buildResult.givenUser());
    assertEquals("Resolved Comment", buildResult.resolvedComment());
    assertEquals("Resolved Role", buildResult.resolvedRole());
    assertEquals("Resolved User", buildResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn(null);
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Role", buildResult.givenRole());
    assertEquals("Given User", buildResult.givenUser());
    assertEquals("Resolved Comment", buildResult.resolvedComment());
    assertEquals("Resolved Role", buildResult.resolvedRole());
    assertEquals("Resolved User", buildResult.resolvedUser());
    assertNull(buildResult.givenComment());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn(null);
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Comment", buildResult.givenComment());
    assertEquals("Given User", buildResult.givenUser());
    assertEquals("Resolved Comment", buildResult.resolvedComment());
    assertEquals("Resolved Role", buildResult.resolvedRole());
    assertEquals("Resolved User", buildResult.resolvedUser());
    assertNull(buildResult.givenRole());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn(null);
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Comment", buildResult.givenComment());
    assertEquals("Given Role", buildResult.givenRole());
    assertEquals("Resolved Comment", buildResult.resolvedComment());
    assertEquals("Resolved Role", buildResult.resolvedRole());
    assertEquals("Resolved User", buildResult.resolvedUser());
    assertNull(buildResult.givenUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn(null);
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Comment", buildResult.givenComment());
    assertEquals("Given Role", buildResult.givenRole());
    assertEquals("Given User", buildResult.givenUser());
    assertEquals("Resolved Role", buildResult.resolvedRole());
    assertEquals("Resolved User", buildResult.resolvedUser());
    assertNull(buildResult.resolvedComment());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn(null);
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Comment", buildResult.givenComment());
    assertEquals("Given Role", buildResult.givenRole());
    assertEquals("Given User", buildResult.givenUser());
    assertEquals("Resolved Comment", buildResult.resolvedComment());
    assertEquals("Resolved User", buildResult.resolvedUser());
    assertNull(buildResult.resolvedRole());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn(null);

    // Act
    ImmutableBulkUserOperationRowPreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    ImmutableBulkUserOperationRowPreview buildResult = builderResult.build();
    assertEquals("Given Comment", buildResult.givenComment());
    assertEquals("Given Role", buildResult.givenRole());
    assertEquals("Given User", buildResult.givenUser());
    assertEquals("Resolved Comment", buildResult.resolvedComment());
    assertEquals("Resolved Role", buildResult.resolvedRole());
    assertNull(buildResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview actualCopyOfResult = ImmutableBulkUserOperationRowPreview.copyOf(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    assertEquals("Given Comment", actualCopyOfResult.givenComment());
    assertEquals("Given Role", actualCopyOfResult.givenRole());
    assertEquals("Given User", actualCopyOfResult.givenUser());
    assertEquals("Resolved Comment", actualCopyOfResult.resolvedComment());
    assertEquals("Resolved Role", actualCopyOfResult.resolvedRole());
    assertEquals("Resolved User", actualCopyOfResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, actualCopyOfResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview actualCopyOfResult = ImmutableBulkUserOperationRowPreview.copyOf(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    assertEquals("", actualCopyOfResult.resolvedComment());
    assertEquals("Given Comment", actualCopyOfResult.givenComment());
    assertEquals("Given Role", actualCopyOfResult.givenRole());
    assertEquals("Given User", actualCopyOfResult.givenUser());
    assertEquals("Resolved Role", actualCopyOfResult.resolvedRole());
    assertEquals("Resolved User", actualCopyOfResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualCopyOfResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("");
    when(instance.resolvedUser()).thenReturn("Resolved User");

    // Act
    ImmutableBulkUserOperationRowPreview actualCopyOfResult = ImmutableBulkUserOperationRowPreview.copyOf(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    assertEquals("", actualCopyOfResult.resolvedRole());
    assertEquals("Given Comment", actualCopyOfResult.givenComment());
    assertEquals("Given Role", actualCopyOfResult.givenRole());
    assertEquals("Given User", actualCopyOfResult.givenUser());
    assertEquals("Resolved Comment", actualCopyOfResult.resolvedComment());
    assertEquals("Resolved User", actualCopyOfResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualCopyOfResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkUserOperationRowPreview instance = mock(BulkUserOperationRowPreview.class);
    when(instance.givenComment()).thenReturn("Given Comment");
    when(instance.givenRole()).thenReturn("Given Role");
    when(instance.givenUser()).thenReturn("Given User");
    when(instance.resolvedComment()).thenReturn("Resolved Comment");
    when(instance.resolvedRole()).thenReturn("Resolved Role");
    when(instance.resolvedUser()).thenReturn("");

    // Act
    ImmutableBulkUserOperationRowPreview actualCopyOfResult = ImmutableBulkUserOperationRowPreview.copyOf(instance);

    // Assert
    verify(instance).givenComment();
    verify(instance).givenRole();
    verify(instance).givenUser();
    verify(instance).resolvedComment();
    verify(instance).resolvedRole();
    verify(instance).resolvedUser();
    assertEquals("", actualCopyOfResult.resolvedUser());
    assertEquals("Given Comment", actualCopyOfResult.givenComment());
    assertEquals("Given Role", actualCopyOfResult.givenRole());
    assertEquals("Given User", actualCopyOfResult.givenUser());
    assertEquals("Resolved Comment", actualCopyOfResult.resolvedComment());
    assertEquals("Resolved Role", actualCopyOfResult.resolvedRole());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualCopyOfResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview
        .fromJson(new ImmutableBulkUserOperationRowPreview.Json());

    // Assert
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole("Json");
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("Json");
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("Json");
    json.setResolvedRole("Json");
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("Json");
    json.setResolvedRole("Json");
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.OK, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment("Json");
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson8() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole("Json");
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson9() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser("Json");
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview#fromJson(ImmutableBulkUserOperationRowPreview.Json)}
   */
  @Test
  void testFromJson10() {
    // Arrange
    ImmutableBulkUserOperationRowPreview.Json json = new ImmutableBulkUserOperationRowPreview.Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("");
    json.setResolvedRole(null);
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("", actualFromJsonResult.resolvedUser());
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedRole());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkUserOperationRowPreview.Json}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Json#setGivenComment(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Json#setGivenRole(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Json#setGivenUser(String)}
   *   <li>
   * {@link ImmutableBulkUserOperationRowPreview.Json#setResolvedComment(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Json#setResolvedRole(String)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview.Json#setResolvedUser(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview.Json actualJson = new ImmutableBulkUserOperationRowPreview.Json();
    actualJson.setGivenComment("Given Comment");
    actualJson.setGivenRole("Given Role");
    actualJson.setGivenUser("Given User");
    actualJson.setResolvedComment("Resolved Comment");
    actualJson.setResolvedRole("Resolved Role");
    actualJson.setResolvedUser("Resolved User");

    // Assert
    assertEquals("Given Comment", actualJson.givenComment);
    assertEquals("Given Role", actualJson.givenRole);
    assertEquals("Given User", actualJson.givenUser);
    assertEquals("Resolved Comment", actualJson.resolvedComment);
    assertEquals("Resolved Role", actualJson.resolvedRole);
    assertEquals("Resolved User", actualJson.resolvedUser);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Json#givenComment()}
   */
  @Test
  void testJsonGivenComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUserOperationRowPreview.Json()).givenComment());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Json#givenRole()}
   */
  @Test
  void testJsonGivenRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUserOperationRowPreview.Json()).givenRole());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Json#givenUser()}
   */
  @Test
  void testJsonGivenUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUserOperationRowPreview.Json()).givenUser());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Json#resolvedComment()}
   */
  @Test
  void testJsonResolvedComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUserOperationRowPreview.Json()).resolvedComment());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Json#resolvedRole()}
   */
  @Test
  void testJsonResolvedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUserOperationRowPreview.Json()).resolvedRole());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUserOperationRowPreview.Json#resolvedUser()}
   */
  @Test
  void testJsonResolvedUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUserOperationRowPreview.Json()).resolvedUser());
  }

  /**
   * Method under test: {@link ImmutableBulkUserOperationRowPreview.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkUserOperationRowPreview.Json()).status());
  }
}
