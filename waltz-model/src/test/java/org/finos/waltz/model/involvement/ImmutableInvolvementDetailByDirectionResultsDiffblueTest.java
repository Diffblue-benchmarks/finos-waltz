package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class ImmutableInvolvementDetailByDirectionResultsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAllAncestors(Iterable)}
   */
  @Test
  void testBuilderAddAllAncestors() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAncestors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAllDescendents(Iterable)}
   */
  @Test
  void testBuilderAddAllDescendents() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDescendents(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAllExact(Iterable)}
   */
  @Test
  void testBuilderAddAllExact() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllExact(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAncestors(InvolvementDetail)}
   */
  @Test
  void testBuilderAddAncestors() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddAncestorsResult = builderResult
        .addAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAncestors(InvolvementDetail)}
   */
  @Test
  void testBuilderAddAncestors2() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    ImmutableInvolvementDetail.Json element = new ImmutableInvolvementDetail.Json();
    element.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddAncestorsResult = builderResult.addAncestors(element);

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAncestors(InvolvementDetail[])}
   */
  @Test
  void testBuilderAddAncestors3() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddAncestorsResult = builderResult
        .addAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addAncestors(InvolvementDetail[])}
   */
  @Test
  void testBuilderAddAncestors4() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    ImmutableInvolvementDetail.Json json = new ImmutableInvolvementDetail.Json();
    json.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddAncestorsResult = builderResult.addAncestors(json);

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addDescendents(InvolvementDetail)}
   */
  @Test
  void testBuilderAddDescendents() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddDescendentsResult = builderResult
        .addDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addDescendents(InvolvementDetail)}
   */
  @Test
  void testBuilderAddDescendents2() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    ImmutableInvolvementDetail.Json element = new ImmutableInvolvementDetail.Json();
    element.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddDescendentsResult = builderResult
        .addDescendents(element);

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addDescendents(InvolvementDetail[])}
   */
  @Test
  void testBuilderAddDescendents3() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddDescendentsResult = builderResult
        .addDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addDescendents(InvolvementDetail[])}
   */
  @Test
  void testBuilderAddDescendents4() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    ImmutableInvolvementDetail.Json json = new ImmutableInvolvementDetail.Json();
    json.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddDescendentsResult = builderResult
        .addDescendents(json);

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addExact(InvolvementDetail)}
   */
  @Test
  void testBuilderAddExact() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddExactResult = builderResult
        .addExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addExact(InvolvementDetail)}
   */
  @Test
  void testBuilderAddExact2() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    ImmutableInvolvementDetail.Json element = new ImmutableInvolvementDetail.Json();
    element.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddExactResult = builderResult.addExact(element);

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addExact(InvolvementDetail[])}
   */
  @Test
  void testBuilderAddExact3() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddExactResult = builderResult
        .addExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#addExact(InvolvementDetail[])}
   */
  @Test
  void testBuilderAddExact4() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    ImmutableInvolvementDetail.Json json = new ImmutableInvolvementDetail.Json();
    json.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualAddExactResult = builderResult.addExact(json);

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#ancestors(Iterable)}
   */
  @Test
  void testBuilderAncestors() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ancestors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableInvolvementDetailByDirectionResults.builder().build().ancestors().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#descendents(Iterable)}
   */
  @Test
  void testBuilderDescendents() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.descendents(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#exact(Iterable)}
   */
  @Test
  void testBuilderExact() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exact(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(new HashSet<>());
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(involvementDetailSet);
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(new HashSet<>());
    when(instance.descendents()).thenReturn(involvementDetailSet);
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Builder builderResult = ImmutableInvolvementDetailByDirectionResults
        .builder();

    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(new HashSet<>());
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(involvementDetailSet);

    // Act
    ImmutableInvolvementDetailByDirectionResults.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(new HashSet<>());
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult = ImmutableInvolvementDetailByDirectionResults
        .copyOf(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    Set<InvolvementDetail> ancestorsResult = actualCopyOfResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualCopyOfResult.descendents());
    assertSame(ancestorsResult, actualCopyOfResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(involvementDetailSet);
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult = ImmutableInvolvementDetailByDirectionResults
        .copyOf(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertEquals(1, actualCopyOfResult.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualCopyOfResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualCopyOfResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(involvementDetailSet);
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult = ImmutableInvolvementDetailByDirectionResults
        .copyOf(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    Set<InvolvementDetail> descendentsResult = actualCopyOfResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertEquals(involvementDetailSet, actualCopyOfResult.ancestors());
    assertSame(descendentsResult, actualCopyOfResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(new HashSet<>());
    when(instance.descendents()).thenReturn(involvementDetailSet);
    when(instance.exact()).thenReturn(new HashSet<>());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult = ImmutableInvolvementDetailByDirectionResults
        .copyOf(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertEquals(1, actualCopyOfResult.descendents().size());
    Set<InvolvementDetail> ancestorsResult = actualCopyOfResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualCopyOfResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<InvolvementDetail> involvementDetailSet = new HashSet<>();
    involvementDetailSet.add(new ImmutableInvolvementDetail.Json());
    InvolvementDetailByDirectionResults instance = mock(InvolvementDetailByDirectionResults.class);
    when(instance.ancestors()).thenReturn(new HashSet<>());
    when(instance.descendents()).thenReturn(new HashSet<>());
    when(instance.exact()).thenReturn(involvementDetailSet);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult = ImmutableInvolvementDetailByDirectionResults
        .copyOf(instance);

    // Assert
    verify(instance).ancestors();
    verify(instance).descendents();
    verify(instance).exact();
    assertEquals(1, actualCopyOfResult.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualCopyOfResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualCopyOfResult.descendents());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Json json = new ImmutableInvolvementDetailByDirectionResults.Json();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    Set<InvolvementDetail> involvementDetailSet = json.exact;
    assertSame(involvementDetailSet, ancestorsResult);
    assertSame(involvementDetailSet, actualFromJsonResult.descendents());
    assertSame(involvementDetailSet, actualFromJsonResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults.Json json = new ImmutableInvolvementDetailByDirectionResults.Json();
    json.setAncestors(null);
    json.setDescendents(null);
    json.setExact(null);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualFromJsonResult.descendents());
    assertSame(ancestorsResult, actualFromJsonResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());

    ImmutableInvolvementDetailByDirectionResults.Json json = new ImmutableInvolvementDetailByDirectionResults.Json();
    json.setAncestors(null);
    json.setDescendents(null);
    json.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualFromJsonResult.descendents());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<InvolvementDetail> descendents = new LinkedHashSet<>();
    descendents.add(new ImmutableInvolvementDetail.Json());

    ImmutableInvolvementDetailByDirectionResults.Json json = new ImmutableInvolvementDetailByDirectionResults.Json();
    json.setAncestors(null);
    json.setDescendents(descendents);
    json.setExact(null);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.descendents().size());
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualFromJsonResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<InvolvementDetail> ancestors = new LinkedHashSet<>();
    ancestors.add(new ImmutableInvolvementDetail.Json());

    ImmutableInvolvementDetailByDirectionResults.Json json = new ImmutableInvolvementDetailByDirectionResults.Json();
    json.setAncestors(ancestors);
    json.setDescendents(null);
    json.setExact(null);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualFromJsonResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualFromJsonResult.exact());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());
    exact.add(new ImmutableInvolvementDetail.Json());

    ImmutableInvolvementDetailByDirectionResults.Json json = new ImmutableInvolvementDetailByDirectionResults.Json();
    json.setAncestors(null);
    json.setDescendents(null);
    json.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertEquals(exact, actualFromJsonResult.exact());
    assertSame(ancestorsResult, actualFromJsonResult.descendents());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults#fromJson(ImmutableInvolvementDetailByDirectionResults.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ImmutableInvolvementDetail.Json json = new ImmutableInvolvementDetail.Json();
    json.setPerson(mock(Person.class));

    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(json);

    ImmutableInvolvementDetailByDirectionResults.Json json2 = new ImmutableInvolvementDetailByDirectionResults.Json();
    json2.setAncestors(null);
    json2.setDescendents(null);
    json2.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualFromJsonResult.descendents());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Json#ancestors()}
   */
  @Test
  void testJsonAncestors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementDetailByDirectionResults.Json()).ancestors());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Json#descendents()}
   */
  @Test
  void testJsonDescendents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementDetailByDirectionResults.Json()).descendents());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetailByDirectionResults.Json#exact()}
   */
  @Test
  void testJsonExact() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementDetailByDirectionResults.Json()).exact());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableInvolvementDetailByDirectionResults.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableInvolvementDetailByDirectionResults.Json actualJson = new ImmutableInvolvementDetailByDirectionResults.Json();

    // Assert
    assertTrue(actualJson.ancestors.isEmpty());
    assertTrue(actualJson.descendents.isEmpty());
    assertTrue(actualJson.exact.isEmpty());
  }
}
