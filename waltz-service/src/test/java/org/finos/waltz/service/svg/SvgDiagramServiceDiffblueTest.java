package org.finos.waltz.service.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.svg.SvgDiagramDao;
import org.finos.waltz.model.svg.ImmutableSvgDiagram;
import org.finos.waltz.model.svg.SvgDiagram;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SvgDiagramServiceDiffblueTest {
  /**
   * Method under test: {@link SvgDiagramService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    SvgDiagram svgDiagram = mock(SvgDiagram.class);
    when(svgDiagram.priority()).thenReturn(1);
    when(svgDiagram.displayHeightPercent()).thenReturn(1);
    when(svgDiagram.displayWidthPercent()).thenReturn(1);
    when(svgDiagram.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(svgDiagram.id()).thenReturn(ofResult);
    when(svgDiagram.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram.keyProperty()).thenReturn("Key Property");
    when(svgDiagram.name()).thenReturn("Name");
    when(svgDiagram.svg()).thenReturn("Svg");
    when(svgDiagram.product()).thenReturn("Product");
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.getById(anyLong())).thenReturn(svgDiagram);

    // Act
    SvgDiagram actualById = (new SvgDiagramService(svgDiagramDao)).getById(1L);

    // Assert
    verify(svgDiagramDao).getById(eq(1L));
    verify(svgDiagram).description();
    verify(svgDiagram).id();
    verify(svgDiagram).name();
    verify(svgDiagram).displayHeightPercent();
    verify(svgDiagram).displayWidthPercent();
    verify(svgDiagram).group();
    verify(svgDiagram).keyProperty();
    verify(svgDiagram).priority();
    verify(svgDiagram, atLeast(1)).product();
    verify(svgDiagram, atLeast(1)).svg();
    assertTrue(actualById instanceof ImmutableSvgDiagram);
    assertEquals("Group", actualById.group());
    assertEquals("Key Property", actualById.keyProperty());
    assertEquals("Name", actualById.name());
    assertEquals("Product", actualById.product());
    assertEquals("Svg", actualById.svg());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.displayHeightPercent().intValue());
    assertEquals(1, actualById.displayWidthPercent().intValue());
    assertEquals(1, actualById.priority());
  }

  /**
   * Method under test: {@link SvgDiagramService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    SvgDiagram svgDiagram = mock(SvgDiagram.class);
    when(svgDiagram.priority()).thenReturn(1);
    when(svgDiagram.displayHeightPercent()).thenReturn(1);
    when(svgDiagram.displayWidthPercent()).thenReturn(1);
    when(svgDiagram.group()).thenReturn("Group");
    Optional<Long> emptyResult = Optional.empty();
    when(svgDiagram.id()).thenReturn(emptyResult);
    when(svgDiagram.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram.keyProperty()).thenReturn("Key Property");
    when(svgDiagram.name()).thenReturn("Name");
    when(svgDiagram.svg()).thenReturn("Svg");
    when(svgDiagram.product()).thenReturn("Product");
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.getById(anyLong())).thenReturn(svgDiagram);

    // Act
    SvgDiagram actualById = (new SvgDiagramService(svgDiagramDao)).getById(1L);

    // Assert
    verify(svgDiagramDao).getById(eq(1L));
    verify(svgDiagram).description();
    verify(svgDiagram).id();
    verify(svgDiagram).name();
    verify(svgDiagram).displayHeightPercent();
    verify(svgDiagram).displayWidthPercent();
    verify(svgDiagram).group();
    verify(svgDiagram).keyProperty();
    verify(svgDiagram).priority();
    verify(svgDiagram, atLeast(1)).product();
    verify(svgDiagram, atLeast(1)).svg();
    assertTrue(actualById instanceof ImmutableSvgDiagram);
    assertEquals("Group", actualById.group());
    assertEquals("Key Property", actualById.keyProperty());
    assertEquals("Name", actualById.name());
    assertEquals("Product", actualById.product());
    assertEquals("Svg", actualById.svg());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.displayHeightPercent().intValue());
    assertEquals(1, actualById.displayWidthPercent().intValue());
    assertEquals(1, actualById.priority());
  }

  /**
   * Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  void testFindByGroups() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(new ArrayList<>());

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult = (new SvgDiagramService(svgDiagramDao)).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    assertTrue(actualFindByGroupsResult instanceof List);
    assertTrue(actualFindByGroupsResult.isEmpty());
  }

  /**
   * Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  void testFindByGroups2() {
    // Arrange
    SvgDiagram svgDiagram = mock(SvgDiagram.class);
    when(svgDiagram.priority()).thenReturn(1);
    when(svgDiagram.displayHeightPercent()).thenReturn(1);
    when(svgDiagram.displayWidthPercent()).thenReturn(1);
    when(svgDiagram.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(svgDiagram.id()).thenReturn(ofResult);
    when(svgDiagram.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram.keyProperty()).thenReturn("Key Property");
    when(svgDiagram.name()).thenReturn("Name");
    when(svgDiagram.svg()).thenReturn("Svg");
    when(svgDiagram.product()).thenReturn("Product");

    ArrayList<SvgDiagram> svgDiagramList = new ArrayList<>();
    svgDiagramList.add(svgDiagram);
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(svgDiagramList);

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult = (new SvgDiagramService(svgDiagramDao)).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    verify(svgDiagram).description();
    verify(svgDiagram).id();
    verify(svgDiagram).name();
    verify(svgDiagram).displayHeightPercent();
    verify(svgDiagram).displayWidthPercent();
    verify(svgDiagram).group();
    verify(svgDiagram).keyProperty();
    verify(svgDiagram).priority();
    verify(svgDiagram, atLeast(1)).product();
    verify(svgDiagram, atLeast(1)).svg();
    assertTrue(actualFindByGroupsResult instanceof List);
    assertEquals(1, actualFindByGroupsResult.size());
    SvgDiagram getResult = ((List<SvgDiagram>) actualFindByGroupsResult).get(0);
    assertTrue(getResult instanceof ImmutableSvgDiagram);
    assertEquals("Group", getResult.group());
    assertEquals("Key Property", getResult.keyProperty());
    assertEquals("Name", getResult.name());
    assertEquals("Product", getResult.product());
    assertEquals("Svg", getResult.svg());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, getResult.displayHeightPercent().intValue());
    assertEquals(1, getResult.displayWidthPercent().intValue());
    assertEquals(1, getResult.priority());
  }

  /**
   * Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  void testFindByGroups3() {
    // Arrange
    SvgDiagram svgDiagram = mock(SvgDiagram.class);
    when(svgDiagram.priority()).thenReturn(1);
    when(svgDiagram.displayHeightPercent()).thenReturn(1);
    when(svgDiagram.displayWidthPercent()).thenReturn(1);
    when(svgDiagram.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(svgDiagram.id()).thenReturn(ofResult);
    when(svgDiagram.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram.keyProperty()).thenReturn("Key Property");
    when(svgDiagram.name()).thenReturn("Name");
    when(svgDiagram.svg()).thenReturn("Svg");
    when(svgDiagram.product()).thenReturn("Product");
    SvgDiagram svgDiagram2 = mock(SvgDiagram.class);
    when(svgDiagram2.priority()).thenReturn(1);
    when(svgDiagram2.displayHeightPercent()).thenReturn(1);
    when(svgDiagram2.displayWidthPercent()).thenReturn(1);
    when(svgDiagram2.group()).thenReturn("Group");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(svgDiagram2.id()).thenReturn(ofResult2);
    when(svgDiagram2.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram2.keyProperty()).thenReturn("Key Property");
    when(svgDiagram2.name()).thenReturn("Name");
    when(svgDiagram2.svg()).thenReturn("Svg");
    when(svgDiagram2.product()).thenReturn("Product");

    ArrayList<SvgDiagram> svgDiagramList = new ArrayList<>();
    svgDiagramList.add(svgDiagram2);
    svgDiagramList.add(svgDiagram);
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(svgDiagramList);

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult = (new SvgDiagramService(svgDiagramDao)).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    verify(svgDiagram2).description();
    verify(svgDiagram).description();
    verify(svgDiagram2).id();
    verify(svgDiagram).id();
    verify(svgDiagram2).name();
    verify(svgDiagram).name();
    verify(svgDiagram2).displayHeightPercent();
    verify(svgDiagram).displayHeightPercent();
    verify(svgDiagram2).displayWidthPercent();
    verify(svgDiagram).displayWidthPercent();
    verify(svgDiagram2).group();
    verify(svgDiagram).group();
    verify(svgDiagram2).keyProperty();
    verify(svgDiagram).keyProperty();
    verify(svgDiagram2).priority();
    verify(svgDiagram).priority();
    verify(svgDiagram2, atLeast(1)).product();
    verify(svgDiagram, atLeast(1)).product();
    verify(svgDiagram2, atLeast(1)).svg();
    verify(svgDiagram, atLeast(1)).svg();
    assertTrue(actualFindByGroupsResult instanceof List);
    assertEquals(2, actualFindByGroupsResult.size());
    SvgDiagram getResult = ((List<SvgDiagram>) actualFindByGroupsResult).get(0);
    assertTrue(getResult instanceof ImmutableSvgDiagram);
    SvgDiagram getResult2 = ((List<SvgDiagram>) actualFindByGroupsResult).get(1);
    assertTrue(getResult2 instanceof ImmutableSvgDiagram);
    assertEquals("Group", getResult.group());
    assertEquals("Key Property", getResult.keyProperty());
    assertEquals("Name", getResult.name());
    assertEquals("Product", getResult.product());
    assertEquals("Svg", getResult.svg());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, getResult.displayHeightPercent().intValue());
    assertEquals(1, getResult.displayWidthPercent().intValue());
    assertEquals(1, getResult.priority());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  void testFindByGroups4() {
    // Arrange
    SvgDiagram svgDiagram = mock(SvgDiagram.class);
    when(svgDiagram.priority()).thenReturn(1);
    when(svgDiagram.displayHeightPercent()).thenReturn(1);
    when(svgDiagram.displayWidthPercent()).thenReturn(1);
    when(svgDiagram.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(svgDiagram.id()).thenReturn(ofResult);
    when(svgDiagram.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram.keyProperty()).thenReturn("Key Property");
    when(svgDiagram.name()).thenReturn("Name");
    when(svgDiagram.svg()).thenReturn("Svg");
    when(svgDiagram.product()).thenReturn("Product");
    SvgDiagram svgDiagram2 = mock(SvgDiagram.class);
    when(svgDiagram2.priority()).thenReturn(1);
    when(svgDiagram2.displayHeightPercent()).thenReturn(1);
    when(svgDiagram2.displayWidthPercent()).thenReturn(1);
    when(svgDiagram2.group()).thenReturn("Group");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(svgDiagram2.id()).thenReturn(ofResult2);
    when(svgDiagram2.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram2.keyProperty()).thenReturn("Key Property");
    when(svgDiagram2.name()).thenReturn("Name");
    when(svgDiagram2.svg()).thenReturn("Svg");
    when(svgDiagram2.product()).thenReturn("Product");
    SvgDiagram svgDiagram3 = mock(SvgDiagram.class);
    when(svgDiagram3.priority()).thenReturn(1);
    when(svgDiagram3.displayHeightPercent()).thenReturn(1);
    when(svgDiagram3.displayWidthPercent()).thenReturn(1);
    when(svgDiagram3.group()).thenReturn("Group");
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(svgDiagram3.id()).thenReturn(ofResult3);
    when(svgDiagram3.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram3.keyProperty()).thenReturn("Key Property");
    when(svgDiagram3.name()).thenReturn("Name");
    when(svgDiagram3.svg()).thenReturn("Svg");
    when(svgDiagram3.product()).thenReturn("Product");
    SvgDiagram svgDiagram4 = mock(SvgDiagram.class);
    when(svgDiagram4.priority()).thenReturn(1);
    when(svgDiagram4.displayHeightPercent()).thenReturn(1);
    when(svgDiagram4.displayWidthPercent()).thenReturn(1);
    when(svgDiagram4.group()).thenReturn("Group");
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(svgDiagram4.id()).thenReturn(ofResult4);
    when(svgDiagram4.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram4.keyProperty()).thenReturn("Key Property");
    when(svgDiagram4.name()).thenReturn("Name");
    when(svgDiagram4.svg()).thenReturn("Svg");
    when(svgDiagram4.product()).thenReturn("Product");
    SvgDiagram svgDiagram5 = mock(SvgDiagram.class);
    when(svgDiagram5.priority()).thenReturn(1);
    when(svgDiagram5.displayHeightPercent()).thenReturn(1);
    when(svgDiagram5.displayWidthPercent()).thenReturn(1);
    when(svgDiagram5.group()).thenReturn("Group");
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(svgDiagram5.id()).thenReturn(ofResult5);
    when(svgDiagram5.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram5.keyProperty()).thenReturn("Key Property");
    when(svgDiagram5.name()).thenReturn("Name");
    when(svgDiagram5.svg()).thenReturn("Svg");
    when(svgDiagram5.product()).thenReturn("Product");
    SvgDiagram svgDiagram6 = mock(SvgDiagram.class);
    when(svgDiagram6.priority()).thenReturn(1);
    when(svgDiagram6.displayHeightPercent()).thenReturn(1);
    when(svgDiagram6.displayWidthPercent()).thenReturn(1);
    when(svgDiagram6.group()).thenReturn("Group");
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(svgDiagram6.id()).thenReturn(ofResult6);
    when(svgDiagram6.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram6.keyProperty()).thenReturn("Key Property");
    when(svgDiagram6.name()).thenReturn("Name");
    when(svgDiagram6.svg()).thenReturn("Svg");
    when(svgDiagram6.product()).thenReturn("Product");
    SvgDiagram svgDiagram7 = mock(SvgDiagram.class);
    when(svgDiagram7.priority()).thenReturn(1);
    when(svgDiagram7.displayHeightPercent()).thenReturn(1);
    when(svgDiagram7.displayWidthPercent()).thenReturn(1);
    when(svgDiagram7.group()).thenReturn("Group");
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(svgDiagram7.id()).thenReturn(ofResult7);
    when(svgDiagram7.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram7.keyProperty()).thenReturn("Key Property");
    when(svgDiagram7.name()).thenReturn("Name");
    when(svgDiagram7.svg()).thenReturn("Svg");
    when(svgDiagram7.product()).thenReturn("Product");
    SvgDiagram svgDiagram8 = mock(SvgDiagram.class);
    when(svgDiagram8.priority()).thenReturn(1);
    when(svgDiagram8.displayHeightPercent()).thenReturn(1);
    when(svgDiagram8.displayWidthPercent()).thenReturn(1);
    when(svgDiagram8.group()).thenReturn("Group");
    Optional<Long> ofResult8 = Optional.<Long>of(1L);
    when(svgDiagram8.id()).thenReturn(ofResult8);
    when(svgDiagram8.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram8.keyProperty()).thenReturn("Key Property");
    when(svgDiagram8.name()).thenReturn("Name");
    when(svgDiagram8.svg()).thenReturn("Svg");
    when(svgDiagram8.product()).thenReturn("Product");
    SvgDiagram svgDiagram9 = mock(SvgDiagram.class);
    when(svgDiagram9.priority()).thenReturn(1);
    when(svgDiagram9.displayHeightPercent()).thenReturn(1);
    when(svgDiagram9.displayWidthPercent()).thenReturn(1);
    when(svgDiagram9.group()).thenReturn("Group");
    Optional<Long> ofResult9 = Optional.<Long>of(1L);
    when(svgDiagram9.id()).thenReturn(ofResult9);
    when(svgDiagram9.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram9.keyProperty()).thenReturn("Key Property");
    when(svgDiagram9.name()).thenReturn("Name");
    when(svgDiagram9.svg()).thenReturn("Svg");
    when(svgDiagram9.product()).thenReturn("Product");
    SvgDiagram svgDiagram10 = mock(SvgDiagram.class);
    when(svgDiagram10.priority()).thenReturn(1);
    when(svgDiagram10.displayHeightPercent()).thenReturn(1);
    when(svgDiagram10.displayWidthPercent()).thenReturn(1);
    when(svgDiagram10.group()).thenReturn("Group");
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(svgDiagram10.id()).thenReturn(ofResult10);
    when(svgDiagram10.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram10.keyProperty()).thenReturn("Key Property");
    when(svgDiagram10.name()).thenReturn("Name");
    when(svgDiagram10.svg()).thenReturn("Svg");
    when(svgDiagram10.product()).thenReturn("Product");
    SvgDiagram svgDiagram11 = mock(SvgDiagram.class);
    when(svgDiagram11.priority()).thenReturn(1);
    when(svgDiagram11.displayHeightPercent()).thenReturn(1);
    when(svgDiagram11.displayWidthPercent()).thenReturn(1);
    when(svgDiagram11.group()).thenReturn("Group");
    Optional<Long> ofResult11 = Optional.<Long>of(1L);
    when(svgDiagram11.id()).thenReturn(ofResult11);
    when(svgDiagram11.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram11.keyProperty()).thenReturn("Key Property");
    when(svgDiagram11.name()).thenReturn("Name");
    when(svgDiagram11.svg()).thenReturn("Svg");
    when(svgDiagram11.product()).thenReturn("Product");
    SvgDiagram svgDiagram12 = mock(SvgDiagram.class);
    when(svgDiagram12.priority()).thenReturn(1);
    when(svgDiagram12.displayHeightPercent()).thenReturn(1);
    when(svgDiagram12.displayWidthPercent()).thenReturn(1);
    when(svgDiagram12.group()).thenReturn("Group");
    Optional<Long> ofResult12 = Optional.<Long>of(1L);
    when(svgDiagram12.id()).thenReturn(ofResult12);
    when(svgDiagram12.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram12.keyProperty()).thenReturn("Key Property");
    when(svgDiagram12.name()).thenReturn("Name");
    when(svgDiagram12.svg()).thenReturn("Svg");
    when(svgDiagram12.product()).thenReturn("Product");
    SvgDiagram svgDiagram13 = mock(SvgDiagram.class);
    when(svgDiagram13.priority()).thenReturn(1);
    when(svgDiagram13.displayHeightPercent()).thenReturn(1);
    when(svgDiagram13.displayWidthPercent()).thenReturn(1);
    when(svgDiagram13.group()).thenReturn("Group");
    Optional<Long> ofResult13 = Optional.<Long>of(1L);
    when(svgDiagram13.id()).thenReturn(ofResult13);
    when(svgDiagram13.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram13.keyProperty()).thenReturn("Key Property");
    when(svgDiagram13.name()).thenReturn("Name");
    when(svgDiagram13.svg()).thenReturn("Svg");
    when(svgDiagram13.product()).thenReturn("Product");
    SvgDiagram svgDiagram14 = mock(SvgDiagram.class);
    when(svgDiagram14.priority()).thenReturn(1);
    when(svgDiagram14.displayHeightPercent()).thenReturn(1);
    when(svgDiagram14.displayWidthPercent()).thenReturn(1);
    when(svgDiagram14.group()).thenReturn("Group");
    Optional<Long> ofResult14 = Optional.<Long>of(1L);
    when(svgDiagram14.id()).thenReturn(ofResult14);
    when(svgDiagram14.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram14.keyProperty()).thenReturn("Key Property");
    when(svgDiagram14.name()).thenReturn("Name");
    when(svgDiagram14.svg()).thenReturn("Svg");
    when(svgDiagram14.product()).thenReturn("Product");
    SvgDiagram svgDiagram15 = mock(SvgDiagram.class);
    when(svgDiagram15.priority()).thenReturn(1);
    when(svgDiagram15.displayHeightPercent()).thenReturn(1);
    when(svgDiagram15.displayWidthPercent()).thenReturn(1);
    when(svgDiagram15.group()).thenReturn("Group");
    Optional<Long> ofResult15 = Optional.<Long>of(1L);
    when(svgDiagram15.id()).thenReturn(ofResult15);
    when(svgDiagram15.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram15.keyProperty()).thenReturn("Key Property");
    when(svgDiagram15.name()).thenReturn("Name");
    when(svgDiagram15.svg()).thenReturn("Svg");
    when(svgDiagram15.product()).thenReturn("Product");
    SvgDiagram svgDiagram16 = mock(SvgDiagram.class);
    when(svgDiagram16.priority()).thenReturn(1);
    when(svgDiagram16.displayHeightPercent()).thenReturn(1);
    when(svgDiagram16.displayWidthPercent()).thenReturn(1);
    when(svgDiagram16.group()).thenReturn("Group");
    Optional<Long> ofResult16 = Optional.<Long>of(1L);
    when(svgDiagram16.id()).thenReturn(ofResult16);
    when(svgDiagram16.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram16.keyProperty()).thenReturn("Key Property");
    when(svgDiagram16.name()).thenReturn("Name");
    when(svgDiagram16.svg()).thenReturn("Svg");
    when(svgDiagram16.product()).thenReturn("Product");
    SvgDiagram svgDiagram17 = mock(SvgDiagram.class);
    when(svgDiagram17.priority()).thenReturn(1);
    when(svgDiagram17.displayHeightPercent()).thenReturn(1);
    when(svgDiagram17.displayWidthPercent()).thenReturn(1);
    when(svgDiagram17.group()).thenReturn("Group");
    Optional<Long> emptyResult = Optional.empty();
    when(svgDiagram17.id()).thenReturn(emptyResult);
    when(svgDiagram17.description()).thenReturn("The characteristics of someone or something");
    when(svgDiagram17.keyProperty()).thenReturn("Key Property");
    when(svgDiagram17.name()).thenReturn("Name");
    when(svgDiagram17.svg()).thenReturn("Svg");
    when(svgDiagram17.product()).thenReturn("Product");

    ArrayList<SvgDiagram> svgDiagramList = new ArrayList<>();
    svgDiagramList.add(svgDiagram17);
    svgDiagramList.add(svgDiagram16);
    svgDiagramList.add(svgDiagram15);
    svgDiagramList.add(svgDiagram14);
    svgDiagramList.add(svgDiagram13);
    svgDiagramList.add(svgDiagram12);
    svgDiagramList.add(svgDiagram11);
    svgDiagramList.add(svgDiagram10);
    svgDiagramList.add(svgDiagram9);
    svgDiagramList.add(svgDiagram8);
    svgDiagramList.add(svgDiagram7);
    svgDiagramList.add(svgDiagram6);
    svgDiagramList.add(svgDiagram5);
    svgDiagramList.add(svgDiagram4);
    svgDiagramList.add(svgDiagram3);
    svgDiagramList.add(svgDiagram2);
    svgDiagramList.add(svgDiagram);
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(svgDiagramList);

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult = (new SvgDiagramService(svgDiagramDao)).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    verify(svgDiagram17).description();
    verify(svgDiagram16).description();
    verify(svgDiagram15).description();
    verify(svgDiagram14).description();
    verify(svgDiagram13).description();
    verify(svgDiagram12).description();
    verify(svgDiagram11).description();
    verify(svgDiagram10).description();
    verify(svgDiagram9).description();
    verify(svgDiagram8).description();
    verify(svgDiagram7).description();
    verify(svgDiagram6).description();
    verify(svgDiagram5).description();
    verify(svgDiagram4).description();
    verify(svgDiagram3).description();
    verify(svgDiagram2).description();
    verify(svgDiagram).description();
    verify(svgDiagram17).id();
    verify(svgDiagram16).id();
    verify(svgDiagram15).id();
    verify(svgDiagram14).id();
    verify(svgDiagram13).id();
    verify(svgDiagram12).id();
    verify(svgDiagram11).id();
    verify(svgDiagram10).id();
    verify(svgDiagram9).id();
    verify(svgDiagram8).id();
    verify(svgDiagram7).id();
    verify(svgDiagram6).id();
    verify(svgDiagram5).id();
    verify(svgDiagram4).id();
    verify(svgDiagram3).id();
    verify(svgDiagram2).id();
    verify(svgDiagram).id();
    verify(svgDiagram17).name();
    verify(svgDiagram16).name();
    verify(svgDiagram15).name();
    verify(svgDiagram14).name();
    verify(svgDiagram13).name();
    verify(svgDiagram12).name();
    verify(svgDiagram11).name();
    verify(svgDiagram10).name();
    verify(svgDiagram9).name();
    verify(svgDiagram8).name();
    verify(svgDiagram7).name();
    verify(svgDiagram6).name();
    verify(svgDiagram5).name();
    verify(svgDiagram4).name();
    verify(svgDiagram3).name();
    verify(svgDiagram2).name();
    verify(svgDiagram).name();
    verify(svgDiagram17).displayHeightPercent();
    verify(svgDiagram16).displayHeightPercent();
    verify(svgDiagram15).displayHeightPercent();
    verify(svgDiagram14).displayHeightPercent();
    verify(svgDiagram13).displayHeightPercent();
    verify(svgDiagram12).displayHeightPercent();
    verify(svgDiagram11).displayHeightPercent();
    verify(svgDiagram10).displayHeightPercent();
    verify(svgDiagram9).displayHeightPercent();
    verify(svgDiagram8).displayHeightPercent();
    verify(svgDiagram7).displayHeightPercent();
    verify(svgDiagram6).displayHeightPercent();
    verify(svgDiagram5).displayHeightPercent();
    verify(svgDiagram4).displayHeightPercent();
    verify(svgDiagram3).displayHeightPercent();
    verify(svgDiagram2).displayHeightPercent();
    verify(svgDiagram).displayHeightPercent();
    verify(svgDiagram17).displayWidthPercent();
    verify(svgDiagram16).displayWidthPercent();
    verify(svgDiagram15).displayWidthPercent();
    verify(svgDiagram14).displayWidthPercent();
    verify(svgDiagram13).displayWidthPercent();
    verify(svgDiagram12).displayWidthPercent();
    verify(svgDiagram11).displayWidthPercent();
    verify(svgDiagram10).displayWidthPercent();
    verify(svgDiagram9).displayWidthPercent();
    verify(svgDiagram8).displayWidthPercent();
    verify(svgDiagram7).displayWidthPercent();
    verify(svgDiagram6).displayWidthPercent();
    verify(svgDiagram5).displayWidthPercent();
    verify(svgDiagram4).displayWidthPercent();
    verify(svgDiagram3).displayWidthPercent();
    verify(svgDiagram2).displayWidthPercent();
    verify(svgDiagram).displayWidthPercent();
    verify(svgDiagram17).group();
    verify(svgDiagram16).group();
    verify(svgDiagram15).group();
    verify(svgDiagram14).group();
    verify(svgDiagram13).group();
    verify(svgDiagram12).group();
    verify(svgDiagram11).group();
    verify(svgDiagram10).group();
    verify(svgDiagram9).group();
    verify(svgDiagram8).group();
    verify(svgDiagram7).group();
    verify(svgDiagram6).group();
    verify(svgDiagram5).group();
    verify(svgDiagram4).group();
    verify(svgDiagram3).group();
    verify(svgDiagram2).group();
    verify(svgDiagram).group();
    verify(svgDiagram17).keyProperty();
    verify(svgDiagram16).keyProperty();
    verify(svgDiagram15).keyProperty();
    verify(svgDiagram14).keyProperty();
    verify(svgDiagram13).keyProperty();
    verify(svgDiagram12).keyProperty();
    verify(svgDiagram11).keyProperty();
    verify(svgDiagram10).keyProperty();
    verify(svgDiagram9).keyProperty();
    verify(svgDiagram8).keyProperty();
    verify(svgDiagram7).keyProperty();
    verify(svgDiagram6).keyProperty();
    verify(svgDiagram5).keyProperty();
    verify(svgDiagram4).keyProperty();
    verify(svgDiagram3).keyProperty();
    verify(svgDiagram2).keyProperty();
    verify(svgDiagram).keyProperty();
    verify(svgDiagram17).priority();
    verify(svgDiagram16).priority();
    verify(svgDiagram15).priority();
    verify(svgDiagram14).priority();
    verify(svgDiagram13).priority();
    verify(svgDiagram12).priority();
    verify(svgDiagram11).priority();
    verify(svgDiagram10).priority();
    verify(svgDiagram9).priority();
    verify(svgDiagram8).priority();
    verify(svgDiagram7).priority();
    verify(svgDiagram6).priority();
    verify(svgDiagram5).priority();
    verify(svgDiagram4).priority();
    verify(svgDiagram3).priority();
    verify(svgDiagram2).priority();
    verify(svgDiagram).priority();
    verify(svgDiagram17, atLeast(1)).product();
    verify(svgDiagram16, atLeast(1)).product();
    verify(svgDiagram15, atLeast(1)).product();
    verify(svgDiagram14, atLeast(1)).product();
    verify(svgDiagram13, atLeast(1)).product();
    verify(svgDiagram12, atLeast(1)).product();
    verify(svgDiagram11, atLeast(1)).product();
    verify(svgDiagram10, atLeast(1)).product();
    verify(svgDiagram9, atLeast(1)).product();
    verify(svgDiagram8, atLeast(1)).product();
    verify(svgDiagram7, atLeast(1)).product();
    verify(svgDiagram6, atLeast(1)).product();
    verify(svgDiagram5, atLeast(1)).product();
    verify(svgDiagram4, atLeast(1)).product();
    verify(svgDiagram3, atLeast(1)).product();
    verify(svgDiagram2, atLeast(1)).product();
    verify(svgDiagram, atLeast(1)).product();
    verify(svgDiagram17, atLeast(1)).svg();
    verify(svgDiagram16, atLeast(1)).svg();
    verify(svgDiagram15, atLeast(1)).svg();
    verify(svgDiagram14, atLeast(1)).svg();
    verify(svgDiagram13, atLeast(1)).svg();
    verify(svgDiagram12, atLeast(1)).svg();
    verify(svgDiagram11, atLeast(1)).svg();
    verify(svgDiagram10, atLeast(1)).svg();
    verify(svgDiagram9, atLeast(1)).svg();
    verify(svgDiagram8, atLeast(1)).svg();
    verify(svgDiagram7, atLeast(1)).svg();
    verify(svgDiagram6, atLeast(1)).svg();
    verify(svgDiagram5, atLeast(1)).svg();
    verify(svgDiagram4, atLeast(1)).svg();
    verify(svgDiagram3, atLeast(1)).svg();
    verify(svgDiagram2, atLeast(1)).svg();
    verify(svgDiagram, atLeast(1)).svg();
    assertTrue(actualFindByGroupsResult instanceof List);
    assertEquals(17, actualFindByGroupsResult.size());
    SvgDiagram getResult = ((List<SvgDiagram>) actualFindByGroupsResult).get(0);
    assertTrue(getResult instanceof ImmutableSvgDiagram);
    SvgDiagram getResult2 = ((List<SvgDiagram>) actualFindByGroupsResult).get(1);
    assertTrue(getResult2 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult3 = ((List<SvgDiagram>) actualFindByGroupsResult).get(11);
    assertTrue(getResult3 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult4 = ((List<SvgDiagram>) actualFindByGroupsResult).get(12);
    assertTrue(getResult4 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult5 = ((List<SvgDiagram>) actualFindByGroupsResult).get(13);
    assertTrue(getResult5 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult6 = ((List<SvgDiagram>) actualFindByGroupsResult).get(14);
    assertTrue(getResult6 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult7 = ((List<SvgDiagram>) actualFindByGroupsResult).get(15);
    assertTrue(getResult7 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult8 = ((List<SvgDiagram>) actualFindByGroupsResult).get(2);
    assertTrue(getResult8 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult9 = ((List<SvgDiagram>) actualFindByGroupsResult).get(3);
    assertTrue(getResult9 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult10 = ((List<SvgDiagram>) actualFindByGroupsResult).get(4);
    assertTrue(getResult10 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult11 = ((List<SvgDiagram>) actualFindByGroupsResult).get(5);
    assertTrue(getResult11 instanceof ImmutableSvgDiagram);
    SvgDiagram getResult12 = ((List<SvgDiagram>) actualFindByGroupsResult).get(Short.SIZE);
    assertTrue(getResult12 instanceof ImmutableSvgDiagram);
    assertEquals("Group", getResult.group());
    assertEquals("Group", getResult2.group());
    assertEquals("Key Property", getResult.keyProperty());
    assertEquals("Key Property", getResult2.keyProperty());
    assertEquals("Name", getResult.name());
    assertEquals("Name", getResult2.name());
    assertEquals("Product", getResult.product());
    assertEquals("Product", getResult2.product());
    assertEquals("Svg", getResult.svg());
    assertEquals("Svg", getResult2.svg());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals("The characteristics of someone or something", getResult2.description());
    assertEquals(1, getResult.displayHeightPercent().intValue());
    assertEquals(1, getResult2.displayHeightPercent().intValue());
    assertEquals(1, getResult.displayWidthPercent().intValue());
    assertEquals(1, getResult2.displayWidthPercent().intValue());
    assertEquals(1, getResult.priority());
    assertEquals(1, getResult2.priority());
    assertEquals(getResult2, getResult3);
    assertEquals(getResult2, getResult4);
    assertEquals(getResult2, getResult5);
    assertEquals(getResult2, getResult6);
    assertEquals(getResult2, getResult7);
    assertEquals(getResult2, getResult8);
    assertEquals(getResult2, getResult9);
    assertEquals(getResult2, getResult10);
    assertEquals(getResult2, getResult11);
    assertEquals(getResult2, getResult12);
  }

  /**
   * Method under test: {@link SvgDiagramService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    HashSet<SvgDiagram> svgDiagramSet = new HashSet<>();
    when(svgDiagramDao.findAll()).thenReturn(svgDiagramSet);

    // Act
    Set<SvgDiagram> actualFindAllResult = (new SvgDiagramService(svgDiagramDao)).findAll();

    // Assert
    verify(svgDiagramDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(svgDiagramSet, actualFindAllResult);
  }

  /**
   * Method under test: {@link SvgDiagramService#remove(long)}
   */
  @Test
  void testRemove() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.remove(anyLong())).thenReturn(true);

    // Act
    Boolean actualRemoveResult = (new SvgDiagramService(svgDiagramDao)).remove(1L);

    // Assert
    verify(svgDiagramDao).remove(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link SvgDiagramService#remove(long)}
   */
  @Test
  void testRemove2() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.remove(anyLong())).thenReturn(false);

    // Act
    Boolean actualRemoveResult = (new SvgDiagramService(svgDiagramDao)).remove(1L);

    // Assert
    verify(svgDiagramDao).remove(eq(1L));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link SvgDiagramService#save(SvgDiagram)}
   */
  @Test
  void testSave() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.save(Mockito.<SvgDiagram>any())).thenReturn(true);

    // Act
    Boolean actualSaveResult = (new SvgDiagramService(svgDiagramDao)).save(null);

    // Assert
    verify(svgDiagramDao).save(isNull());
    assertTrue(actualSaveResult);
  }

  /**
   * Method under test: {@link SvgDiagramService#save(SvgDiagram)}
   */
  @Test
  void testSave2() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.save(Mockito.<SvgDiagram>any())).thenReturn(false);

    // Act
    Boolean actualSaveResult = (new SvgDiagramService(svgDiagramDao)).save(null);

    // Assert
    verify(svgDiagramDao).save(isNull());
    assertFalse(actualSaveResult);
  }
}
